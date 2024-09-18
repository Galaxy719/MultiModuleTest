package uz.developersdreamscore.presentation.designsystem.ui.theme

import androidx.compose.ui.graphics.Color

var ColorPrimaryApp = Color(0xFF7286D3)
val ColorWhite = Color(0xFFFFFFFF)
val ColorWhiteLight = Color(0xFFF1F6F9)
val ColorWhiteFade = Color(0xFFE3E5ED)
val ColorBlackGray = Color(0xFF040D12)
val ColorLightGray = Color(0xFF9BA4B5)
val ColorGreen = Color(0xFF00ADB5)
val ColorRed = Color(0xFFFF8989)

sealed class ThemeColors(
    val primary: Color,
    val onPrimary: Color,
    val primaryContainer: Color,
    val onPrimaryContainer: Color,
    val secondary: Color,
    val onSecondary: Color,
    val background: Color,
    val surface: Color,
) {
    data object Dark: ThemeColors(
        primary = Color(0xFF7286D3),
        onPrimary = Color(0xFFF1F6F9),
        primaryContainer = Color(0xFF0094FF),
        onPrimaryContainer = Color(0xFF999999),
        secondary = Color(0xFF645CBB),
        onSecondary = Color(0xFF3E3E3E),
        background = Color(0xFFF1F6F9),
        surface = Color(0xFFF1F6F9),
    )

    data object Light: ThemeColors(
        primary = Color(0xFF7286D3),
        onPrimary = Color(0xFFF1F6F9),
        primaryContainer = Color(0xFF0094FF),
        onPrimaryContainer = Color(0xFF999999),
        secondary = Color(0xFF645CBB),
        onSecondary = Color(0xFF3E3E3E),
        background = Color(0xFFF1F6F9),
        surface = Color(0xFFF1F6F9),
    )
}