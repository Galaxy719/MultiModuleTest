package uz.developersdreams.multimoduletest.navigation.bottomnav

import androidx.compose.ui.graphics.painter.Painter

data class TopLevelRouteModel<T : Any>(val name: String, val route: T, val icon: Painter)
