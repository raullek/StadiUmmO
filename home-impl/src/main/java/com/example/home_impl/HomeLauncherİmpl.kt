package com.example.home_impl

import android.content.Context
import android.content.Intent
import com.example.home_api.HomeLauncher

class HomeLauncherImpl : HomeLauncher {

    override fun launch(context: Context) {
        val intent = Intent(context, HomeActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }

}