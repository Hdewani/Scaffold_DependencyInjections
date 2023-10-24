package com.example.basicapp.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

object Route {
    const val LOGIN = "Login"
    const val DASHBOARD = "Dashboard"
    const val OTP = "Otp"

}

@Composable
fun Chats() {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Hello From Chats!")
    }
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Route.LOGIN) {

//        for login page
        composable(Route.LOGIN) {
            LoginPage(navController = navController)
        }

//        for otp page
        composable(
            route = "$Routes.OTP?phoneNumber={phoneNumber}&password={password}",
            arguments = listOf(
                navArgument("phoneNumber") { type = NavType.StringType },
                navArgument("password") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val phoneNumber = backStackEntry.arguments?.getString("phoneNumber") ?: ""
            val password = backStackEntry.arguments?.getString("password") ?: ""
            OtpPage(navController = navController, phoneNumber = phoneNumber, password = password)
        }


//        for dashboard page
        composable(
            route = "$Routes.DASHBOARD?phoneNumber={phoneNumber}&password={password}",
            arguments = listOf(
                navArgument("phoneNumber") { type = NavType.StringType },
                navArgument("password") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val phoneNumber = backStackEntry.arguments?.getString("phoneNumber") ?: ""
            val password = backStackEntry.arguments?.getString("password") ?: ""
            DashBoard(navController = navController, phoneNumber = phoneNumber, password = password)
        }
    }
}