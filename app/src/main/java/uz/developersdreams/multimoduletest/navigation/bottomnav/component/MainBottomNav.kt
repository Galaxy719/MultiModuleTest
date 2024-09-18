package uz.developersdreams.multimoduletest.navigation.bottomnav.component

import android.util.Log
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.exyte.animatednavbar.animation.balltrajectory.Parabolic
import uz.developersdreams.core.presentation.ui.Graphs
import uz.developersdreams.multimoduletest.navigation.bottomnav.TopLevelRouteModel
import uz.developersdreamscore.presentation.designsystem.ui.theme.ColorPrimaryApp
import uz.developersdreamscore.presentation.designsystem.ui.theme.ColorWhite
import uz.developersdreamscore.presentation.designsystem.ui.theme.ColorWhiteFade

@Composable
fun BottomNav(
    modifier: Modifier = Modifier,
    rootNavController: NavController,
    initialIndex: Int,
    topLevelRoutes: List<TopLevelRouteModel<out Graphs>>,
    selectedIndex: (Int) -> Unit,
) {
    var selected by remember { mutableIntStateOf(initialIndex) }
    val navBackStackEntry by rootNavController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    AnimatedNavigationBar(
        selectedIndex = selected,
        modifier = modifier.height(60.dp),
        ballAnimation = Parabolic(tween(300)),
        barColor = ColorPrimaryApp,
        ballColor = ColorPrimaryApp
    ) {
        topLevelRoutes.forEach { topLevelRoute ->
            val isSelected = currentDestination?.hierarchy?.any { it.hasRoute(topLevelRoute.route::class) } == true
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = MaterialTheme.shapes.large)
                    .clickable {
                        rootNavController.navigate(topLevelRoute.route) {
//                            popUpTo(findStartDestination(rootNavController.graph).id) {
//                                saveState = true
//                            }
                            popUpTo(findStartDestination(rootNavController.graph).id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                            Log.d("TTT", rootNavController.graph.findStartDestination().route.toString())
                        }
                        selected = topLevelRoutes.indexOf(topLevelRoute)
                        selectedIndex(selected)
                    },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = topLevelRoute.icon,
                    contentDescription = "",
                    tint = if (isSelected) ColorWhite
                    else ColorWhiteFade
                )
            }
        }
    }
}

private val NavGraph.startDestination: NavDestination?
    get() = findNode(startDestinationId)

private tailrec fun findStartDestination(graph: NavDestination): NavDestination {
    return if (graph is NavGraph) findStartDestination(graph.startDestination!!) else graph
}