package com.example.connectify.screens

import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.Manifest.permission.READ_MEDIA_IMAGES
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.content.PackageManagerCompat
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.connectify.R
import com.example.connectify.navigation.Routes

@Composable
fun Register(navController: NavHostController) {

    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    var bio by remember {
        mutableStateOf("")
    }

    var userName by remember {
        mutableStateOf("")
    }

    var name by remember {
        mutableStateOf("")
    }

    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }

    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri
    }

    val permissionToRequest = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        READ_MEDIA_IMAGES
    } else{
        READ_EXTERNAL_STORAGE
    }

    val context = LocalContext.current

    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {

        } else {

        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Register Now !",
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 24.sp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Image(

            if (imageUri == null) painterResource(id = R.drawable.avatar) else rememberAsyncImagePainter(
                model = imageUri
            ), contentDescription = "avatar",
            modifier = Modifier
                .size(96.dp)
                .clip(CircleShape)
                .background(Color.LightGray)
                .clickable {

                    val isGranted = ContextCompat.checkSelfPermission(
                        context,
                        permissionToRequest
                    ) == PackageManager.PERMISSION_GRANTED

                    if(isGranted){
                        galleryLauncher.launch("image/*")

                    }

                    else{
                     permissionLauncher.launch(permissionToRequest)
                    }


                }, contentScale = ContentScale.Crop)


        Spacer(modifier = Modifier.height(50.dp))

        OutlinedTextField(value = name, onValueChange = {
            name = it
        }, label = { Text(text = "Your Name") },

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,

                ), singleLine = true, modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(value = email, onValueChange = {
            email = it
        }, label = { Text(text = "Email") },

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,

                ), singleLine = true, modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))


        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = { Text(text = "Password") },


            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,


                ), singleLine = true, modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(value = userName, onValueChange = {
            userName = it
        }, label = { Text(text = "UserName") },

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,

                ), singleLine = true, modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(value = bio, onValueChange = {
            bio = it
        }, label = { Text(text = "Bio") },

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,

                ), modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))


        ElevatedButton(
            onClick = {

                // login using firebase auth

            }, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White
            )
        ) {

            Text(
                text = "Register",
                style = TextStyle(fontWeight = FontWeight.ExtraBold, fontSize = 20.sp)
            )


        }

        TextButton(
            onClick = {
                // redirect to register page

                navController.navigate(Routes.Login.routes) {

                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }

            },
            modifier = Modifier.fillMaxWidth(),
        ) {

            Text(text = "Already have an Account ? Login Now", style = TextStyle(fontSize = 16.sp))


        }


    }
}

//@Composable
//@Preview(showBackground = true , showSystemUi = true)
//fun RegisterPreview(){
//
////    Register(navController)
//
//
//}