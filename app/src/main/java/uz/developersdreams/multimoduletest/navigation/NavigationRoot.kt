package uz.developersdreams.multimoduletest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import uz.developersdreams.auth.presentation.ui.login.components.LoginScreen
import uz.developersdreams.auth.presentation.ui.registraion.components.RegistrationScreen
import uz.developersdreams.core.presentation.ui.Graphs
import uz.developersdreams.core.presentation.ui.Screens
import uz.developersdreams.ui.chart.component.ChartScreen
import uz.developersdreams.ui.chartitem.component.ChartItemScreen
import uz.developersdreams.ui.home.component.HomeScreen
import uz.developersdreams.ui.other.component.OtherScreen
import uz.developersdreams.ui.settings.component.SettingsScreen

@Composable
fun NavigationRoot(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Graphs.GraphAuth
    ) {
        graphAuth(navController)
        graphHome(navController)
        graphChart(navController)
        graphOther(navController)
        graphSettings(navController)
    }
}

fun NavGraphBuilder.graphAuth(
    navController: NavHostController
) {
    navigation<Graphs.GraphAuth>(
        startDestination = Screens.LoginScreen
    ) {
        composable<Screens.LoginScreen> {
            LoginScreen {
                navController.navigate(Graphs.GraphHome) {
                    popUpTo<Graphs.GraphAuth>() {
                        inclusive = true
                    }
                }



//                navController.navigate(it) {
//                    when(it) {
//                        Screens.RegistrationScreen -> {
//                            popUpTo(Screens.LoginScreen) {
//                                inclusive = true
//                                saveState = true
//                            }
//                            restoreState = true
//                        }
//                        else -> {
//                            navController
//                        }
//                    }
//                }
            }
        }
        composable<Screens.RegistrationScreen> {
            RegistrationScreen {
                navController.navigate(it) {
                    when(it) {
                        Screens.LoginScreen -> {
                            popUpTo(Screens.RegistrationScreen) {
                                inclusive = true
                                saveState = true
                            }
                            restoreState = true
                        }
                        else -> {
                            popUpTo(Graphs.GraphAuth) {
                                inclusive = true
                            }
                        }
                    }
                }
            }
        }
    }
}

fun NavGraphBuilder.graphHome(
    navController: NavHostController
) {
    navigation<Graphs.GraphHome>(
        startDestination = Screens.HomeScreen
    ) {
        composable<Screens.HomeScreen> {
            HomeScreen()
        }
    }
}

fun NavGraphBuilder.graphChart(
    navController: NavHostController
) {
    navigation<Graphs.GraphChart>(
        startDestination = Screens.ChartScreen
    ) {
        composable<Screens.ChartScreen> {
            ChartScreen(
                onClick = {
                    navController.navigate(Screens.ChartItemScreen)
                }
            )
        }
        composable<Screens.ChartItemScreen> {
            ChartItemScreen()
        }
    }
}

fun NavGraphBuilder.graphOther(
    navController: NavHostController
) {
    navigation<Graphs.GraphOther>(
        startDestination = Screens.OtherScreen
    ) {
        composable<Screens.OtherScreen> {
            OtherScreen()
        }
    }
}

fun NavGraphBuilder.graphSettings(
    navController: NavHostController
) {
    navigation<Graphs.GraphSettings>(
        startDestination = Screens.SettingsScreen
    ) {
        composable<Screens.SettingsScreen> {
            SettingsScreen()
        }
    }
}