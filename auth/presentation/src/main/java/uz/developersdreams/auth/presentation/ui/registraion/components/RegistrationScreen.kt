package uz.developersdreams.auth.presentation.ui.registraion.components

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
import uz.developersdreams.auth.presentation.ui.registraion.RegistrationIntent
import uz.developersdreams.auth.presentation.ui.registraion.RegistrationState
import uz.developersdreams.auth.presentation.ui.registraion.RegistrationViewModel
import uz.developersdreams.core.presentation.ui.ObserveAsEvents
import uz.developersdreams.core.presentation.ui.Screens
import uz.developersdreams.core.presentation.ui.UiEvent
import uz.developersdreamscore.presentation.designsystem.ui.components.button.CustomButtonLong
import uz.developersdreamscore.presentation.designsystem.ui.components.spacer.Spacer10dp
import uz.developersdreamscore.presentation.designsystem.ui.components.spacer.Spacer20dp
import uz.developersdreamscore.presentation.designsystem.ui.components.text.CustomTextBold
import uz.developersdreamscore.presentation.designsystem.ui.components.text.CustomTextFieldLetter

@Composable
fun RegistrationScreen(
    viewModel: RegistrationViewModel = viewModel(),
    onRegistrationClick: (Screens) -> Unit
) {
    ObserveAsEvents(viewModel.uiEvent) { uiEvent ->
        when(uiEvent) {
            is UiEvent.OnNavigate -> onRegistrationClick(uiEvent.screen)
            else -> Unit
        }
    }

    RegistrationView(
        uiState = viewModel.uiState,
        onIntent = viewModel::onIntent
    )
}

@Composable
private fun RegistrationView(
    modifier: Modifier = Modifier,
    uiState: RegistrationState,
    onIntent: (RegistrationIntent) -> Unit = {}
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
                    text = "Registration Screen"
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
                        onIntent(RegistrationIntent.OnLoginText(it))
                    }
                    Spacer10dp()
                    CustomTextFieldLetter(
                        text = uiState.passwordText,
                        hint = "Password"
                    ) {
                        onIntent(RegistrationIntent.OnPasswordText(it))
                    }
                    Spacer20dp()
                    CustomButtonLong(
                        text = "Login",
                        onClick = { onIntent(RegistrationIntent.OnLoginClick) }
                    )
                    CustomButtonLong(
                        text = "Registration",
                        onClick = { onIntent(RegistrationIntent.OnRegistrationClick) }
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