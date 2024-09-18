package uz.developersdreams.multimoduletest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import uz.developersdreams.core.presentation.ui.Graphs
import uz.developersdreams.core.presentation.ui.Screens
import uz.developersdreams.multimoduletest.navigation.NavigationRoot
import uz.developersdreams.multimoduletest.navigation.bottomnav.TopLevelRouteModel
import uz.developersdreams.multimoduletest.navigation.bottomnav.component.BottomNav
import uz.developersdreamscore.presentation.designsystem.ui.components.text.CustomTextSemiBold
import uz.developersdreamscore.presentation.designsystem.ui.theme.IconChart
import uz.developersdreamscore.presentation.designsystem.ui.theme.IconHome
import uz.developersdreamscore.presentation.designsystem.ui.theme.IconOther
import uz.developersdreamscore.presentation.designsystem.ui.theme.IconSettings
import uz.developersdreamscore.presentation.designsystem.ui.theme.MultiModuleTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val dest by navController.currentBackStackEntryAsState()
            val routes = listOf(
                TopLevelRouteModel("", Graphs.GraphHome, IconHome),
                TopLevelRouteModel("", Graphs.GraphChart, IconChart),
                TopLevelRouteModel("", Graphs.GraphOther, IconOther),
                TopLevelRouteModel("", Graphs.GraphSettings, IconSettings),
            )

            MultiModuleTestTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize().padding(WindowInsets.navigationBars.asPaddingValues()),
                    bottomBar = {
                        BottomNav(
                            rootNavController = navController,
                            initialIndex = 0,
                            topLevelRoutes = routes,
                            selectedIndex = {}
                        )
                    }
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        NavigationRoot(navController)
                        CustomTextSemiBold(
                            text = dest?.destination?.route.toString().plus(Screens.LoginScreen.toString()),
                            maxLines = Int.MAX_VALUE
                        )
                    }
                }
            }
        }
    }
}