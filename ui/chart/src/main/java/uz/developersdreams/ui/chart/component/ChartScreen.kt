package uz.developersdreams.ui.chart.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import uz.developersdreamscore.presentation.designsystem.ui.components.text.CustomTextSemiBold

@Composable
fun ChartScreen(
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.fillMaxSize().clickable { onClick() },
            contentAlignment = Alignment.Center
        ) {
            CustomTextSemiBold(
                text = "Chart"
            )
        }
    }
}