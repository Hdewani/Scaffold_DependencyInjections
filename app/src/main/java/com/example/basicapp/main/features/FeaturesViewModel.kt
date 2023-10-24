package com.example.basicapp.main.features

import androidx.lifecycle.ViewModel
import com.example.basicapp.data.models.User
import com.example.basicapp.data.repo.UserRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FeaturesViewModel @Inject constructor(
    private val UserRepo: UserRepo
) : ViewModel() {
    var Avenger = "Hulk"
    fun getUser(): User {
        return UserRepo.getUser("Groot", 5)
    }
}