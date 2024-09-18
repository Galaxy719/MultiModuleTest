package uz.developersdreamscore.presentation.designsystem.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView

private val DarkColorScheme = darkColorScheme(
    primary = ThemeColors.Dark.primary,
    onPrimary = ThemeColors.Dark.onPrimary,
    primaryContainer = ThemeColors.Dark.primaryContainer,
    onPrimaryContainer = ThemeColors.Dark.onPrimaryContainer,
    secondary = ThemeColors.Dark.secondary,
    onSecondary = ThemeColors.Dark.onSecondary,
    background = ThemeColors.Dark.background,
    surface = ThemeColors.Dark.surface
)

private val LightColorScheme = lightColorScheme(
    primary = ThemeColors.Light.primary,
    onPrimary = ThemeColors.Light.onPrimary,
    primaryContainer = ThemeColors.Light.primaryContainer,
    onPrimaryContainer = ThemeColors.Light.onPrimaryContainer,
    secondary = ThemeColors.Light.secondary,
    onSecondary = ThemeColors.Light.onSecondary,
    background = ThemeColors.Light.background,
    surface = ThemeColors.Light.surface
)

@Composable
fun MultiModuleTestTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = shapes,
        content = content
    )
}

@Composable
fun SetStatusBarColor(color: Int) {
    val view = LocalView.current
    SideEffect {
        try {
            val window = (view.context as Activity).window
            window.statusBarColor = color

        }catch (_ : Exception) {}
    }
}