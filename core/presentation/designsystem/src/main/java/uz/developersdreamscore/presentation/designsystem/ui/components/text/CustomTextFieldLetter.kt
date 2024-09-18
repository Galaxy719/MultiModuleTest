package uz.developersdreamscore.presentation.designsystem.ui.components.text

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import uz.developersdreamscore.presentation.designsystem.ui.theme.ColorLightGray
import uz.developersdreamscore.presentation.designsystem.ui.theme.ColorWhiteFade
import uz.developersdreamscore.presentation.designsystem.ui.theme.ColorWhiteLight
import uz.developersdreamscore.presentation.designsystem.ui.theme.HeightOfTextField
import uz.developersdreamscore.presentation.designsystem.ui.theme.Padding10dp

@Composable
fun CustomTextFieldLetter(
    modifier: Modifier = Modifier,
    text: String,
    hint: String = "",
    color: Color = ColorWhiteLight,
    onTextChanged: (String) -> Unit
) {
    BasicTextField(
        modifier = modifier
            .fillMaxWidth()
            .height(HeightOfTextField)
            .padding(horizontal = Padding10dp)
            .background(ColorLightGray, MaterialTheme.shapes.large),
        singleLine = true,
        textStyle = MaterialTheme.typography.bodyLarge.copy(
            color = color,
            fontWeight = FontWeight.SemiBold
        ),
        value = text,
        onValueChange = {value ->
            onTextChanged.invoke(value)
        },
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.Sentences,
            keyboardType = KeyboardType.Text
        ),
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = Padding10dp),
                contentAlignment = Alignment.CenterStart
            ) {
                if (text.trim().isBlank()) {
                    CustomTextNormal(
                        text = hint,
                        color = ColorWhiteFade
                    )
                }
                innerTextField()
            }
        }
    )
}