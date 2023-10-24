package com.example.basicapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BasicApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}