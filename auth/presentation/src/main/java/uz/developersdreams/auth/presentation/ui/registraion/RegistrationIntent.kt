package uz.developersdreams.auth.presentation.ui.registraion

sealed interface RegistrationIntent {

    data class OnLoginText(val text: String): RegistrationIntent

    data class OnPasswordText(val password: String): RegistrationIntent

    data object OnRegistrationClick: RegistrationIntent

    data object OnLoginClick: RegistrationIntent
}