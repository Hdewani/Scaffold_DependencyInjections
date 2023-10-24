package com.example.basicapp.main

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.basicapp.R
import com.example.basicapp.main.features.FeaturesPage

//object Routes {
//    const val LOGIN = "Login"
//    const val DASHBOARD = "Dashboard"
//    const val OTP = "Otp"
//
//}

object Routes {
    const val FEATURES_PAGE = "features"
    const val PROFILE_PAGE = "profile"
    const val SHORTS = "shorts"
    const val CHAT = "chat"
    const val SETTINGS = "settings"
}

data class BottomNavItem(val title: String, val icon: Int, val route: String)

val scaffoldEnabledRoutes = listOf(
    Routes.FEATURES_PAGE,
    Routes.PROFILE_PAGE,
    Routes.SHORTS,
    Routes.CHAT,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    Scaffold(
        topBar = {
            // Customize the top app bar as needed
            TopAppBar(
                title = {
                    Text("TopAppBar")
                },
                actions = {
                    IconButton(
                        onClick = { /* Handle action */ },

                        ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_search),
                            modifier = Modifier.size(50.dp),
                            contentDescription = "Search"
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.DarkGray,
                    titleContentColor = Color.White,
                ),
            )
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Handle FAB click */ }
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = " "
                )
            }
        },


        bottomBar = {
            if (currentRoute in scaffoldEnabledRoutes) {
                var selectedItem = remember { mutableIntStateOf(0) }
                val items = listOf(
                    BottomNavItem(
                        title = "Features",
                        icon = androidx.core.R.drawable.ic_call_answer,
                        route = Routes.FEATURES_PAGE
                    ),
                    BottomNavItem(
                        title = "Chat",
                        icon = androidx.core.R.drawable.ic_call_decline,
                        route = Routes.CHAT
                    ),
                    BottomNavItem(
                        title = "Shorts",
                        icon = androidx.core.R.drawable.ic_call_answer_video,
                        route = Routes.SHORTS
                    ),
                    BottomNavItem(
                        title = "Profile",
                        icon = R.drawable.ic_add,
                        route = Routes.PROFILE_PAGE
                    ),
                )
                NavigationBar {
                    items.forEachIndexed { index, item ->
                        NavigationBarItem(
                            icon = {
                                Icon(
                                    painter = painterResource(id = item.icon),
                                    contentDescription = null,
                                    modifier = Modifier.size(24.dp)
                                )
                            },
                            label = { Text(item.title) },
                            selected = selectedItem.value == index,
                            onClick = {
                                selectedItem.value = index
                                navController.navigate(item.route)
                            }
                        )
                    }
                }
            }

        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
        ) {
            NavHost(
                navController = navController,
                startDestination = Routes.PROFILE_PAGE,
                enterTransition = { ->
                    slideInHorizontally(
                        initialOffsetX = { 300 },
                        animationSpec = tween(
                            300,
                            easing = FastOutSlowInEasing
                        )
                    ) + fadeIn(
                        animationSpec = tween(
                            300,
                            easing = FastOutSlowInEasing
                        )
                    )
                },
                exitTransition = {
                    slideOutHorizontally(
                        targetOffsetX = { 0 },
                        animationSpec = tween(
                            300,
                            easing = FastOutSlowInEasing
                        )
                    ) + fadeOut(
                        animationSpec = tween(
                            300,
                            easing = FastOutSlowInEasing
                        )
                    )
                },
            ) {
                composable(Routes.FEATURES_PAGE) {
                    FeaturesPage()
                }
                composable(Routes.PROFILE_PAGE) {
                    ProfilePage()
                }
                composable(Routes.SHORTS) {
                    Shorts()
                }
                composable(Routes.CHAT) {
                    Chats()
                }
                composable(Routes.SETTINGS) {
                    SettingsPage()
                }
            }
        }
    }

}
//    NavHost(navController = navController, startDestination = Routes.LOGIN) {
//
////        for login page
//        composable(Routes.LOGIN) {
//            LoginPage(navController = navController)
//        }
//
////        for otp page
//        composable(
//            route = "$Routes.OTP?phoneNumber={phoneNumber}&password={password}",
//            arguments = listOf(
//                navArgument("phoneNumber") { type = NavType.StringType },
//                navArgument("password") { type = NavType.StringType }
//            )
//        ) { backStackEntry ->
//            val phoneNumber = backStackEntry.arguments?.getString("phoneNumber") ?: ""
//            val password = backStackEntry.arguments?.getString("password") ?: ""
//            OtpPage(navController = navController, phoneNumber = phoneNumber, password = password)
//        }
//
//
////        for dashboard page
//        composable(
//            route = "$Routes.DASHBOARD?phoneNumber={phoneNumber}&password={password}",
//            arguments = listOf(
//                navArgument("phoneNumber") { type = NavType.StringType },
//                navArgument("password") { type = NavType.StringType }
//            )
//        ) { backStackEntry ->
//            val phoneNumber = backStackEntry.arguments?.getString("phoneNumber") ?: ""
//            val password = backStackEntry.arguments?.getString("password") ?: ""
//            DashBoard(navController = navController, phoneNumber = phoneNumber, password = password)
//        }
//    }
