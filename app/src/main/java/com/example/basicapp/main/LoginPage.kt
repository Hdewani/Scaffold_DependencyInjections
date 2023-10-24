package com.example.basicapp.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(navController: NavController) {
    Column(
//        verticalArrangement = Arrangement.Center
        horizontalAlignment = Alignment.CenterHorizontally,

        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(color = Color(0xFF0F1C27))
    ) {

        data class UserCredentials(val phoneNumber: String, val password: String)

        val userCredentialsList = listOf(
            UserCredentials("123", "hitika"),
            UserCredentials("456", "harsh"),
            UserCredentials("789", "aman"),
            UserCredentials("1011", "deepak"),
        )

        @Composable
        fun LoginPage() {
            var phonenumber by rememberSaveable { mutableStateOf("") }
            var password by rememberSaveable { mutableStateOf("") }

            val performLogin: (String, String) -> Boolean = { enteredPhoneNumber, enteredPassword ->
                userCredentialsList.any { it.phoneNumber == enteredPhoneNumber && it.password == enteredPassword }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Login",
                    color = Color(0xFF55E5C8),
                    style = MaterialTheme.typography.displayLarge,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline,
                    letterSpacing = 0.8.sp,
                )
                Spacer(modifier = Modifier.height(34.dp))

                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "User Icon",
                    tint = Color(0xFF55E5C8),
                    modifier = Modifier
                        .size(150.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(24.dp))

                TextField(
                    value = phonenumber,
                    onValueChange = { phonenumber = it },
                    placeholder = { Text("Phone number") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        cursorColor = Color(0xFF55E5C8),
                        focusedIndicatorColor = Color.White,
                        unfocusedIndicatorColor = Color(0xFF55E5C8),
                        containerColor = Color.Black
                    ),
                )

                TextField(
                    value = password,
                    onValueChange = { password = it },
                    colors = TextFieldDefaults.textFieldColors(
                        cursorColor = Color(0xFF55E5C8),
                        focusedIndicatorColor = Color.White,
                        unfocusedIndicatorColor = Color(0xFF55E5C8),
                        containerColor = Color.Black
                    ),

                    placeholder = { Text("Password") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )

                Spacer(modifier = Modifier.height(26.dp))

                Button(
                    onClick = {
                        if (performLogin(phonenumber, password)) {
                            val route = "$Routes.OTP?phoneNumber=$phonenumber&password=$password"
                            navController.navigate(route)
                        }
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    colors = ButtonDefaults.buttonColors(Color(0xFF55E5C8)),
                    shape = RectangleShape,

                    ) {
                    Text(
                        text = "Login",
                        style = MaterialTheme.typography.titleSmall,
                        color = Color.Black,

                        )
                }
            }
        }

        LoginPage()
    }
}