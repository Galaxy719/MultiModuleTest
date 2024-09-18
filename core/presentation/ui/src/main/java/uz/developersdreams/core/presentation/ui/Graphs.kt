package uz.developersdreams.core.presentation.ui

import kotlinx.serialization.Serializable

sealed interface Graphs {

    @Serializable
    data object GraphAuth: Graphs

    @Serializable
    data object GraphHome: Graphs

    @Serializable
    data object GraphChart: Graphs

    @Serializable
    data object GraphOther: Graphs

    @Serializable
    data object GraphSettings: Graphs
}