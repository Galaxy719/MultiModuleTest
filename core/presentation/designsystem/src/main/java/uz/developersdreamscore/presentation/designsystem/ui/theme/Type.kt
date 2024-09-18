package uz.developersdreamscore.presentation.designsystem.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import uz.developersdreamscore.presentation.designsystem.R

val UbuntuFontFamily = FontFamily(
    Font(R.font.ubuntu_light, FontWeight.Light),
    Font(R.font.ubuntu_regular, FontWeight.Normal),
    Font(R.font.ubuntu_medium, FontWeight.Medium),
    Font(R.font.ubuntu_bold, FontWeight.Bold),
)

val Typography = Typography(
    titleSmall = TextStyle(
        fontFamily = UbuntuFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = SizeOfText20sp
    ),
    titleMedium = TextStyle(
        fontFamily = UbuntuFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = SizeOfText24sp
    ),
    titleLarge = TextStyle(
        fontFamily = UbuntuFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = SizeOfText28sp
    ),
    bodySmall = TextStyle(
        fontFamily = UbuntuFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = SizeOfText14sp
    ),
    bodyMedium = TextStyle(
        fontFamily = UbuntuFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = SizeOfText16sp
    ),
    bodyLarge = TextStyle(
        fontFamily = UbuntuFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = SizeOfText18sp
    )
)