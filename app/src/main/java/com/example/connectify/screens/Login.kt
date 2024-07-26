package com.example.connectify.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.connectify.navigation.Routes

@Composable

fun Login(navHostController: NavController){

    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }


    Column(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) {

        Text(text = "Login", style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 24.sp) )

        Spacer(modifier = Modifier.height(50.dp))

        OutlinedTextField(value = email , onValueChange = {
            email = it
        },            label = { Text(text = "Email")},

            keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,

        ), singleLine = true, modifier = Modifier.fillMaxWidth() )

        Spacer(modifier = Modifier.height(25.dp))


        OutlinedTextField(value = password ,
            onValueChange = {
            email = it
        },
            label = { Text(text = "Password")},


            keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,


            ), singleLine = true, modifier = Modifier.fillMaxWidth() )

        Spacer(modifier = Modifier.height(25.dp))

        ElevatedButton(onClick = {

            // login using firebase auth

        }, modifier = Modifier.fillMaxWidth() ,colors = ButtonDefaults.buttonColors(
            containerColor = Color.Blue,
            contentColor = Color.White
        )) {

            Text(text = "Login", style = TextStyle(fontWeight = FontWeight.ExtraBold, fontSize = 20.sp) )

            
        }

        TextButton(onClick = {
            // redirect to register page
            
            navHostController.navigate(Routes.Register.routes){

                popUpTo(navHostController.graph.startDestinationId)
                launchSingleTop = true
            }

        }, modifier = Modifier.fillMaxWidth() ,) {

            Text(text = "Don't have an Account ? Register Now", style = TextStyle( fontSize = 16.sp) )


        }




    }
}

//@Composable
//@Preview(showBackground = true , showSystemUi = true)
//
//fun LoginPreview(){
//
////    Login()
//
//}