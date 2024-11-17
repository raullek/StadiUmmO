package com.example.stadiummo

import android.app.Application
import com.example.stadiummo.di.ModulesDelegateInitializer

class StadiumoApp :Application() {

    override fun onCreate() {
        super.onCreate()
        ModulesDelegateInitializer.initialize()
    }
}