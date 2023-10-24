package com.example.basicapp.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun OtpPage(navController: NavController, phoneNumber: String, password: String) {
    var otp = remember { mutableStateOf("") }



    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(
            text = "Otp screen",
            color = Color(0xFF55E5C8),
            style = MaterialTheme.typography.displayLarge,
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline,
            letterSpacing = 0.8.sp,

            )


        Text(text = "Enter OTP")
        Spacer(modifier = Modifier.height(16.dp))



        TextField(
            value = otp.value,
            onValueChange = { otp.value = it },
            label = { Text(text = "Enter OTP") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
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

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (otp.value == "5555") {
                    val route = "$Routes.DASHBOARD?phoneNumber=$phoneNumber&password=$password"
                    navController.navigate(route)
                }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(Color(0xFF55E5C8)),
            shape = RectangleShape,

            ) {
            Text(
                text = "Proceed to Dashboard",
                style = MaterialTheme.typography.titleSmall,
                color = Color.Black,
            )

        }
    }
}


