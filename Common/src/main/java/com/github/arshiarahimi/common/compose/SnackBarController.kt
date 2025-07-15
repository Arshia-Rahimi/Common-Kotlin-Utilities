package com.github.arshiarahimi.common.compose

import androidx.annotation.StringRes
import androidx.compose.material3.SnackbarDuration
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

data class SnackBarAction(
    val name: String,
    val action: () -> Unit,
)

data class SnackBarEvent(
    val message: String,
    @param:StringRes val resMessage: Int? = null,
    val action: SnackBarAction? = null,
    val isImmediate: Boolean = false,
    val duration: SnackbarDuration = SnackbarDuration.Long,
)

object SnackBarController {
    private val _events = Channel<SnackBarEvent>()
    val events = _events.receiveAsFlow()

    suspend fun sendEvent(event: SnackBarEvent) {
        _events.send(event)
    }

    suspend fun sendEvent(message: String) {
        _events.send(SnackBarEvent(message))
    }

    suspend fun sendEvent(@StringRes message: Int) {
        _events.send(SnackBarEvent("", message))
    }
}
