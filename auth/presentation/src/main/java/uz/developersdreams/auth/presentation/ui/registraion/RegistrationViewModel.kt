package uz.developersdreams.auth.presentation.ui.registraion

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import uz.developersdreams.core.presentation.ui.Screens
import uz.developersdreams.core.presentation.ui.UiEvent

class RegistrationViewModel : ViewModel() {

    var uiState by mutableStateOf(RegistrationState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onIntent(intent: RegistrationIntent) {
        when(intent) {
            is RegistrationIntent.OnLoginClick -> onLogin()
            is RegistrationIntent.OnLoginText -> onLoginText(intent.text)
            is RegistrationIntent.OnPasswordText -> onPasswordText(intent.password)
            is RegistrationIntent.OnRegistrationClick -> onRegistration()
        }
    }

    private fun onLoginText(text: String) {
        uiState = uiState.copy(
            loginText = text
        )
    }

    private fun onPasswordText(password: String) {
        uiState = uiState.copy(
            passwordText = password
        )
    }

    private fun onLogin() {
        sendUiEvent(UiEvent.OnNavigate(Screens.LoginScreen))
    }

    private fun onRegistration() {
        sendUiEvent(UiEvent.OnNavigate(Screens.HomeScreen))
    }

    private fun sendUiEvent(uiEvent: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(uiEvent)
        }
    }
}