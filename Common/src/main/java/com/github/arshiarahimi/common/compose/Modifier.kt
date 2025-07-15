package com.github.arshiarahimi.common.compose

import androidx.compose.runtime.Composable
import java.lang.reflect.Modifier

@Composable
fun Modifier.onCondition(
    condition: Boolean,
    onFalse: @Composable Modifier.() -> Modifier = { this },
    onTrue: @Composable Modifier.() -> Modifier
): Modifier =
    if (condition) onTrue() else onFalse()
