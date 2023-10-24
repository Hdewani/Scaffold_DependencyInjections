package com.example.basicapp.main.features

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun FeaturesPage(featuresViewModel: FeaturesViewModel = hiltViewModel()) {
    val user = featuresViewModel.getUser()
    featuresViewModel.Avenger = "Thor"
    Column {
        Text(text = "Hello From Features!")
        Text(text = "Name=${user.name}")
        Text(text = "Age=${user.age}")
        Text(text = "Avenger=${featuresViewModel.Avenger}")

    }

}

@Composable
fun NewAvenger(featuresViewModel: FeaturesViewModel = hiltViewModel()) {
    Text(text = "Avenger:${featuresViewModel.Avenger}")
}