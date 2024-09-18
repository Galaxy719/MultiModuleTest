package uz.developersdreams.ui.home.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import uz.developersdreams.ui.home.HomeIntent
import uz.developersdreams.ui.home.HomeState
import uz.developersdreams.ui.home.HomeViewModel
import uz.developersdreamscore.presentation.designsystem.ui.components.text.CustomTextSemiBold

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel()
) {
    HomeView(
        uiState = viewModel.uiState,
        onIntent = viewModel::onIntent
    )
}

@Composable
private fun HomeView(
    modifier: Modifier = Modifier,
    uiState: HomeState,
    onIntent: (HomeIntent) -> Unit = {}
) {
    Surface(
        modifier = modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CustomTextSemiBold(
                text = "Home"
            )
        }
    }
}