package com.example.connectify

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.connectify.navigation.NavGraph
import com.example.connectify.ui.theme.ConnectifyTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConnectifyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {

//                    Text(text = "Hello World", modifier = Modifier.padding(innerPadding))


                }

                val navController = rememberNavController()
                NavGraph(navController = navController)

            }
        }
    }
}

