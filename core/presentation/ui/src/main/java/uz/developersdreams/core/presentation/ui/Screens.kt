package uz.developersdreams.core.presentation.ui

import kotlinx.serialization.Serializable

sealed interface Screens {

    @Serializable
    data object LoginScreen: Screens

    @Serializable
    data object RegistrationScreen: Screens

    @Serializable
    data object HomeScreen: Screens

    @Serializable
    data object ChartScreen: Screens

    @Serializable
    data object OtherScreen: Screens

    @Serializable
    data object SettingsScreen: Screens

    @Serializable
    data object ChartItemScreen: Screens
}