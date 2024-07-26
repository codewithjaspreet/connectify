package com.example.connectify.navigation

sealed class Routes(val routes : String) {

    object Home : Routes("home")
    object Notifications : Routes("notifications")
    object Profile : Routes("profile")
    object Search : Routes("search")
    object Splash : Routes("Splash")
    object AddPost : Routes("addPost")
    object BottomNav : Routes("bottomnav")
    object Login : Routes("login")
    object Register : Routes("register")



}