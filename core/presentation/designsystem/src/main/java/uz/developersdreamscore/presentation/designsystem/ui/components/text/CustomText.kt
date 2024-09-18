package uz.developersdreamscore.presentation.designsystem.ui.components.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import uz.developersdreamscore.presentation.designsystem.ui.theme.ColorPrimaryApp

@Composable
fun CustomTextNormal(
    modifier: Modifier = Modifier,
    text: String = "",
    color: Color = ColorPrimaryApp,
    style: TextStyle = MaterialTheme.typography.bodyMedium,
    align: TextAlign = TextAlign.Start,
    overFlow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = 1
) {
    Text(
        modifier = modifier,
        text = text,
        style = style.copy(
            color = color
        ),
        textAlign = align,
        overflow = overFlow,
        maxLines = maxLines,
    )
}

@Composable
fun CustomTextSemiBold(
    modifier: Modifier = Modifier,
    text: String = "",
    color: Color = ColorPrimaryApp,
    style: TextStyle = MaterialTheme.typography.bodyMedium,
    align: TextAlign = TextAlign.Start,
    overFlow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = 1
) {
    Text(
        modifier = modifier,
        text = text,
        style = style.copy(
            color = color,
            fontWeight = FontWeight.SemiBold
        ),
        textAlign = align,
        overflow = overFlow,
        maxLines = maxLines,
    )
}

@Composable
fun CustomTextBold(
    modifier: Modifier = Modifier,
    text: String = "",
    color: Color = ColorPrimaryApp,
    style: TextStyle = MaterialTheme.typography.bodyMedium,
    align: TextAlign = TextAlign.Start,
    overFlow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = 1
) {
    Text(
        modifier = modifier,
        text = text,
        style = style.copy(
            color = color,
            fontWeight = FontWeight.Bold
        ),
        textAlign = align,
        overflow = overFlow,
        maxLines = maxLines,
    )
}