package uz.developersdreams.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import uz.developersdreams.core.presentation.ui.UiEvent

class HomeViewModel : ViewModel() {

    var uiState by mutableStateOf(HomeState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onIntent(intent: HomeIntent) {

    }
}