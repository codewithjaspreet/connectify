package com.example.connectify.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.connectify.models.BottomNavItem
import com.example.connectify.navigation.Routes


@Composable

fun BottomNavBar(navController: NavHostController){

    val navController1 = rememberNavController()


    Scaffold(
        bottomBar = { myBottomBar(navController1) }
    ) { innerPadding ->
        NavHost(navController = navController1, modifier = Modifier.padding(innerPadding) , startDestination = Routes.Home.routes ){

            composable(Routes.Splash.routes) {
                Splash(navController1)
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

        }
    }


}


@Composable
fun myBottomBar(navController1: NavHostController) {


    val backStackEntry = navController1.currentBackStackEntryAsState()


    val navItems = listOf(
        BottomNavItem(
            itemName = "Home",
            itemIcon = Icons.Default.Home,
            itemRoute = "home"
        ),
        BottomNavItem(
            itemName = "Search",
            itemIcon = Icons.Default.Search,
            itemRoute = "search"
        ),
        BottomNavItem(
            itemName = "AddPost",
            itemIcon = Icons.Default.Add,
            itemRoute = "addpost"
        ),
        BottomNavItem(
            itemName = "Notifications",
            itemIcon = Icons.Default.Notifications,
            itemRoute = "notifications"
        ),
        BottomNavItem(
            itemName = "Profile",
            itemIcon = Icons.Default.Person,
            itemRoute = "profile"
        )
    )

    BottomAppBar {

        navItems.forEach {

            val selected = it.itemRoute == backStackEntry.value?.destination?.route

            NavigationBarItem(selected = selected, onClick = {

                navController1.navigate(it.itemRoute) {

                    popUpTo(navController1.graph.findStartDestination().id) {
                        saveState = true
                    }

                    launchSingleTop = true
                }

            }, icon = {

                Icon(imageVector = it.itemIcon, contentDescription = it.itemName)

            })

        }


    }

}
