package uz.developersdreams.auth.presentation.ui.login.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import uz.developersdreams.auth.presentation.ui.login.LoginIntent
import uz.developersdreams.auth.presentation.ui.login.LoginState
import uz.developersdreams.auth.presentation.ui.login.LoginViewModel
import uz.developersdreams.core.presentation.ui.ObserveAsEvents
import uz.developersdreams.core.presentation.ui.Screens
import uz.developersdreams.core.presentation.ui.UiEvent
import uz.developersdreamscore.presentation.designsystem.ui.components.button.CustomButtonLong
import uz.developersdreamscore.presentation.designsystem.ui.components.spacer.Spacer10dp
import uz.developersdreamscore.presentation.designsystem.ui.components.spacer.Spacer20dp
import uz.developersdreamscore.presentation.designsystem.ui.components.text.CustomTextBold
import uz.developersdreamscore.presentation.designsystem.ui.components.text.CustomTextFieldLetter

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = viewModel(),
    onRegistrationClick: (Screens) -> Unit
) {
    ObserveAsEvents(viewModel.uiEvent) { uiEvent ->
        when(uiEvent) {
            is UiEvent.OnNavigate -> onRegistrationClick(uiEvent.screen)
            else -> Unit
        }
    }

    LoginView(
        uiState = viewModel.uiState,
        onIntent = viewModel::onIntent
    )
}

@Composable
private fun LoginView(
    modifier: Modifier = Modifier,
    uiState: LoginState,
    onIntent: (LoginIntent) -> Unit = {}
) {
    Surface(
        modifier = modifier.fillMaxSize()
    ) {
        Column(modifier = modifier.fillMaxSize()) {
            BoxAlignCenter(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1F)
            ) {
                CustomTextBold(
                    text = "Login Screen"
                )
            }
            BoxAlignCenter(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2F)
            ) {
                Column {
                    CustomTextFieldLetter(
                        text = uiState.loginText,
                        hint = "Login"
                    ) {
                        onIntent(LoginIntent.OnLoginText(it))
                    }
                    Spacer10dp()
                    CustomTextFieldLetter(
                        text = uiState.passwordText,
                        hint = "Password"
                    ) {
                        onIntent(LoginIntent.OnPasswordText(it))
                    }
                    Spacer20dp()
                    CustomButtonLong(
                        text = "Login",
                        onClick = { onIntent(LoginIntent.OnLoginClick) }
                    )
                    CustomButtonLong(
                        text = "Registration",
                        onClick = { onIntent(LoginIntent.OnRegistrationClick) }
                    )
                }
            }
        }
    }
}

@Composable
private fun BoxAlignCenter(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}