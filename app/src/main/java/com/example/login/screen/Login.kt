package com.example.login.screen

import android.widget.Toast
import com.example.csci3310.MainActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.Unspecified
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.csci3310.Screen
import com.example.csci3310.R
import com.example.login.ui.theme.*


@Composable
fun LoginScreen(navController: NavController,onLoginSuccess:() -> Unit){
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    var nameError by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf("") }
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.login_2),
            contentDescription = "demo background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
    }

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Text(text = "Press\n\nto\n\nDress", fontSize = 48.sp, fontFamily = titlefontFamily , textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(500.dp))

    }

    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Spacer(modifier = Modifier.height(340.dp))
        TextField(
            value = username,
            onValueChange = {username = it},
            singleLine = true,
            label = { Text(nameError.ifEmpty { "Username" },color = if (nameError.isNotEmpty()) Red else Unspecified ) },
            leadingIcon = {
                Icon(
                    Icons.Rounded.AccountCircle,
                    contentDescription =  "" )

            },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .width(260.dp)
                .padding(vertical = 4.dp, horizontal = 20.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Transparent,
                unfocusedIndicatorColor = Transparent
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = password,
            onValueChange = {password = it},
            singleLine = true,
            label = { Text(passwordError.ifEmpty { "Password" },color = if (passwordError.isNotEmpty()) Red else Unspecified ) },
            leadingIcon = {
                Icon(
                    Icons.Rounded.Lock,
                    contentDescription =  "" )

            },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (passwordVisible)
                    painterResource(id = R.drawable.visibility_24px)
                else painterResource(id = R.drawable.visibility_off_24px)
                Icon(
                    painter = image,
                    contentDescription = "",

                    modifier = Modifier
                        .size(24.dp)
                        .clickable { passwordVisible = !passwordVisible }
                )
            },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .width(260.dp)
                .padding(vertical = 4.dp, horizontal = 20.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Transparent,
                unfocusedIndicatorColor = Transparent
            )
        )
        //Login Button
        Button(
            onClick = {
                nameError = if (username.isBlank()) "Username is required" else ""
                passwordError = if (password.isBlank()) "Password is required" else ""

                if (username == "admin" && password == "admin"){
                    println("Login Page Success")
                    onLoginSuccess()
                }
            },
            modifier = Modifier
                .width(200.dp)
                .padding(15.dp)
            ,
            colors = ButtonDefaults.buttonColors(LoginPageButtonColor),
            shape = RoundedCornerShape(30.dp),
        ){
            Text(text = "Login", color = Black, fontFamily = PromptfontFamily, fontSize = 16.sp,fontWeight = FontWeight.Bold)
        }

        Text(text = "Forget Password",
            color = LoginPageText,
            fontFamily = PromptfontFamily,
            fontSize = 14.sp,
            style = TextStyle(textDecoration = TextDecoration.Underline),
            modifier = Modifier.clickable{
                navController.navigate(Screen.ForgetPassword.route)

            })
        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Not a member?\n Sign in Now!",
            color = LoginPageText,
            fontFamily = PromptfontFamily,
            fontSize = 14.sp,
            style = TextStyle(textDecoration = TextDecoration.Underline),
            modifier = Modifier.clickable{
                navController.navigate(Screen.Register.route)
                },
            )

    }
}