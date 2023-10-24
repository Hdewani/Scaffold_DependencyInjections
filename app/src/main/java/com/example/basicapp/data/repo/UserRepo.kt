package com.example.basicapp.data.repo

import com.example.basicapp.data.models.User


interface UserRepo {
    fun getUser(name: String, age: Int): User
}