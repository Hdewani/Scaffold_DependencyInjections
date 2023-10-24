package com.example.basicapp.data.repo

import com.example.basicapp.data.models.User

class UserRepoImpl : UserRepo {
    override fun getUser(name: String, age: Int): User {
        return User(name, age)
    }
}