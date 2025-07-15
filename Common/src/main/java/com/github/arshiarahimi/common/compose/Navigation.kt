package com.github.arshiarahimi.common.compose

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavType
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json

class GenericNavType<T>(
    private val serializer: KSerializer<T>,
    nullable: Boolean = false,
) : NavType<T?>(nullable) {
    override fun get(bundle: Bundle, key: String): T? =
        bundle.getString(key)?.let { key -> Json.decodeFromString(serializer, key) }
    
    override fun put(bundle: Bundle, key: String, value: T?) {
        if (value != null || !isNullableAllowed)
            bundle.putString(key, Json.encodeToString(serializer, value!!))
    }
    
    override fun serializeAsValue(value: T?): String =
        Uri.encode(Json.encodeToString(serializer, value!!))
    
    override fun parseValue(value: String): T? =
        Json.decodeFromString(serializer, Uri.decode(value))
    
}

fun NavController.getCurrentRouteClassName() =
    currentBackStackEntry?.destination?.route?.split(".")?.last()

fun NavController.popToRoot() {
    val root = graph.startDestinationRoute ?: return
    popBackStack(
        route = root,
        inclusive = false,
    )
}
