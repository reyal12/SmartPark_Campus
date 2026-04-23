package com.example.smartparkcampus.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Register : Screen("register")
    object Dashboard : Screen("dashboard")
    object SlotMonitoring : Screen("slot_monitoring")
    object Reservation : Screen("reservation")
    object Inbound : Screen("inbound")
    object Outbound : Screen("outbound")
    object ParkingHistory : Screen("parking_history")
}
