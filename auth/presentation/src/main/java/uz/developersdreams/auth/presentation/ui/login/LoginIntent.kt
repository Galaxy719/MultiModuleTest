package uz.developersdreams.auth.presentation.ui.login

sealed interface LoginIntent {

    data class OnLoginText(val text: String): LoginIntent

    data class OnPasswordText(val password: String): LoginIntent

    data object OnRegistrationClick: LoginIntent

    data object OnLoginClick: LoginIntent
}