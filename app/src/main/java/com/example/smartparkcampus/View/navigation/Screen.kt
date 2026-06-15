package com.example.smartparkcampus.View.navigation

import android.net.Uri

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Login : Screen("login")
    object Register : Screen("register")
    
    object Dashboard : Screen("dashboard/{name}/{lastName}/{email}/{image}") {
        fun createRoute(firstName: String, lastName: String, email: String, image: String): String {
            val encodedImage = Uri.encode(image)
            return "dashboard/$firstName/$lastName/$email/$encodedImage"
        }
    }
    
    object Profile : Screen("profile/{firstName}/{lastName}/{email}/{image}") {
        fun createRoute(firstName: String, lastName: String, email: String, image: String): String {
            val encodedImage = Uri.encode(image)
            return "profile/$firstName/$lastName/$email/$encodedImage"
        }
    }

    object SlotMonitoring : Screen("slot_monitoring")
    object Reservation : Screen("reservation")
    object Inbound : Screen("inbound")
    object Outbound : Screen("outbound")
    object ParkingHistory : Screen("parking_history")
}
