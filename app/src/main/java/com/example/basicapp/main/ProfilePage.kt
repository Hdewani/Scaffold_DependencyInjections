package com.example.basicapp.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ProfilePage() {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Hello From Profile Page!")


    }
}