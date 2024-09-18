package uz.developersdreams.core.presentation.ui

sealed interface UiEvent {
    data object OnNavigateUp: UiEvent
    data class OnNavigate(val screen: Screens): UiEvent
}