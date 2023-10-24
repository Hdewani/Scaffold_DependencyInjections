package com.example.basicapp.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashBoard(navController: NavController, phoneNumber: String, password: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Dashboard-Screen",
            color = Color(0xFF55E5C8),
            style = MaterialTheme.typography.displayMedium,
            fontWeight = FontWeight.Bold,
            letterSpacing = 0.9.sp,

            )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Welcome User=$phoneNumber and Password=$password",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 0.8.sp,
            modifier = Modifier.padding(16.dp),

            )
        Spacer(modifier = Modifier.height(24.dp))


        Button(
            onClick = { navController.navigate(Routes.CHAT) },
            modifier = Modifier.align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(Color(0xFF55E5C8)),
            shape = RectangleShape,
        ) {
            Text(
                text = "Go back to Login page",
                style = MaterialTheme.typography.titleSmall,
                color = Color.Black,
            )
        }
    }


}