package com.example.connectify.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.connectify.screens.AddPost
import com.example.connectify.screens.BottomNavBar
import com.example.connectify.screens.Home
import com.example.connectify.screens.Login
import com.example.connectify.screens.Notification
import com.example.connectify.screens.Profile
import com.example.connectify.screens.Register
import com.example.connectify.screens.Search
import com.example.connectify.screens.Splash


@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Routes.Splash.routes
    ) {

        composable(Routes.Splash.routes) {
            Splash(navController)
        }
        composable(Routes.Home.routes) {
            Home()
        }
        composable(Routes.Search.routes) {
            Search()
        }
        composable(Routes.Notifications.routes) {
            Notification()
        }
        composable(Routes.Profile.routes) {
            Profile()
        }
        composable(Routes.AddPost.routes) {
            AddPost()
        }
        composable(Routes.BottomNav.routes) {
            BottomNavBar(navController)
        }
        composable(Routes.Login.routes) {
            Login(navController)
        }
        composable(Routes.Register.routes) {
            Register(navController)
        }
    }

}