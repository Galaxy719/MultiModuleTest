package uz.developersdreamscore.presentation.designsystem.ui.components.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import uz.developersdreamscore.presentation.designsystem.ui.components.text.CustomTextSemiBold
import uz.developersdreamscore.presentation.designsystem.ui.theme.HeightOfCustomButton
import uz.developersdreamscore.presentation.designsystem.ui.theme.Padding10dp

@Composable
fun CustomButtonLong(
    modifier: Modifier = Modifier,
    text: String = "",
    textColor: Color = MaterialTheme.colorScheme.onPrimary,
    buttonColor: Color = MaterialTheme.colorScheme.primary,
    onClick: () -> Unit = {}
) {
    Button(
        modifier = modifier
            .padding(Padding10dp)
            .fillMaxWidth()
            .height(HeightOfCustomButton),
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(buttonColor),
        shape = MaterialTheme.shapes.large
    ) {
        CustomTextSemiBold(
            modifier = Modifier,
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            color = textColor,
            align = TextAlign.Center
        )
    }
}