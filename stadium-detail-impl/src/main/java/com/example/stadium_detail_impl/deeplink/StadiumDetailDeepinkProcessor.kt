package com.example.stadium_detail_impl.deeplink

import android.content.Context
import android.content.Intent
import com.example.core_deeplink.DeeplinkProcessor
import com.example.stadium_detail_impl.StadiumDetailActivity
import javax.inject.Inject

class StadiumDetailDeeplinkProcessor @Inject constructor(private val context: Context): DeeplinkProcessor {
    override fun matches(deeplink: String): Boolean {
        return deeplink.contains("/home")
    }

    override fun execute(deeplink: String) {
        val intent = Intent(context, StadiumDetailActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }
}