package com.example.smartparkcampus.View.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.smartparkcampus.data.remote.retrofit.RetrofitClient
import com.example.smartparkcampus.data.repository.AuthRepository
import com.example.smartparkcampus.View.screen.dashboard.DashboardScreen
import com.example.smartparkcampus.View.screen.history.HistoryScreen
import com.example.smartparkcampus.View.screen.inbound.InboundScreen
import com.example.smartparkcampus.View.screen.login.LoginScreen
import com.example.smartparkcampus.View.screen.login.LoginViewModel
import com.example.smartparkcampus.View.screen.monitoring.MonitoringScreen
import com.example.smartparkcampus.View.screen.outbound.OutboundScreen
import com.example.smartparkcampus.View.screen.register.RegisterScreen
import com.example.smartparkcampus.View.screen.reservation.ReservationScreen
import com.example.smartparkcampus.View.screen.splash.SplashScreen
import com.example.smartparkcampus.View.screen.profile.ProfileScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(onTimeout = {
                navController.navigate(Screen.Login.route) {
                    popUpTo(Screen.Splash.route) { inclusive = true }
                }
            })
        }
        
       composable(Screen.Login.route) {
            val authApi = RetrofitClient.instance
            val repository = AuthRepository(authApi)
            val viewModel: LoginViewModel = viewModel(
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return LoginViewModel(repository) as T
                    }
                }
            )
            
            LoginScreen(
                viewModel = viewModel,
                onLoginSuccess = { uiState ->
                    navController.navigate(
                        Screen.Dashboard.createRoute(
                            firstName = uiState.firstName ?: "User",
                            lastName = uiState.lastName ?: "",
                            email = uiState.email ?: "",
                            image = uiState.image ?: ""
                        )
                    ) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.Register.route) {
            RegisterScreen(onNavigateBack = { navController.popBackStack() })
        }

        composable(
            route = Screen.Dashboard.route,
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("lastName") { type = NavType.StringType },
                navArgument("email") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val firstName = backStackEntry.arguments?.getString("name") ?: "Mahasiswa"
            val lastName = backStackEntry.arguments?.getString("lastName") ?: ""
            val email = backStackEntry.arguments?.getString("email") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""

            DashboardScreen(
                firstName = firstName,
                lastName = lastName,
                email = email,
                image = image,
                onNavigate = { route ->
                    navController.navigate(route)
                },
                onLogout = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(0) { inclusive = true }
                    }
                },
                onProfileClick = {
                    navController.navigate(
                        Screen.Profile.createRoute(firstName, lastName, email, image)
                    )
                }
            )
        }

        composable(
            route = Screen.Profile.route,
            arguments = listOf(
                navArgument("firstName") { type = NavType.StringType },
                navArgument("lastName") { type = NavType.StringType },
                navArgument("email") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val firstName = backStackEntry.arguments?.getString("firstName") ?: ""
            val lastName = backStackEntry.arguments?.getString("lastName") ?: ""
            val email = backStackEntry.arguments?.getString("email") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""

            ProfileScreen(
                firstName = firstName,
                lastName = lastName,
                email = email,
                image = image,
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable(Screen.SlotMonitoring.route) {
            MonitoringScreen(onNavigateBack = { navController.popBackStack() })
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
            HistoryScreen(onNavigateBack = { navController.popBackStack() })
        }
    }
}
