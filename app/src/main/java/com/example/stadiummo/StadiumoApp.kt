package com.example.stadiummo

import android.app.Application
import android.content.Context
import com.example.stadiummo.modules.ModulesDelegateInitializer

class StadiumoApp :Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        ModulesDelegateInitializer.initialize()
    }

    companion object {
        private lateinit var instance: StadiumoApp

        fun getContext(): Context {
            return instance.applicationContext
        }
    }
}