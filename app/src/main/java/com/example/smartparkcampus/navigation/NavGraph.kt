package com.example.smartparkcampus.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.smartparkcampus.ui.screens.*

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            LoginScreen(
                onNavigateToRegister = { navController.navigate(Screen.Register.route) },
                onNavigateToDashboard = { 
                    navController.navigate(Screen.Dashboard.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                }
            )
        }
        composable(Screen.Register.route) {
            RegisterScreen(onNavigateBack = { navController.popBackStack() })
        }
        composable(Screen.Dashboard.route) {
            DashboardScreen(onNavigate = { route ->
                navController.navigate(route)
            })
        }
        composable(Screen.SlotMonitoring.route) {
            SlotMonitoringScreen(onNavigateBack = { navController.popBackStack() })
        }
        composable(Screen.Reservation.route) {
            ReservationScreen(onNavigateBack = { navController.popBackStack() })
        }
        composable(Screen.Inbound.route) {
            InboundScreen(onNavigateBack = { navController.popBackStack() })
        }
        composable(Screen.Outbound.route) {
            OutboundScreen(onNavigateBack = { navController.popBackStack() })
        }
        composable(Screen.ParkingHistory.route) {
            ParkingHistoryScreen(onNavigateBack = { navController.popBackStack() })
        }
    }
}
