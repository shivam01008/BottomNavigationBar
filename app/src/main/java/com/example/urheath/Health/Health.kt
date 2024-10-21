package com.example.urheath.Health

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class Health : Application() {

    override fun onCreate() {
        super.onCreate()
        app = this

    }
    companion object{
        lateinit var app: Health

    }
}