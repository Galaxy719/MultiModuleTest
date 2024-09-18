package uz.developersdreams.ui.settings.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import uz.developersdreamscore.presentation.designsystem.ui.components.text.CustomTextSemiBold

@Composable
fun SettingsScreen(

) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CustomTextSemiBold(
                text = "Settings"
            )
        }
    }
}