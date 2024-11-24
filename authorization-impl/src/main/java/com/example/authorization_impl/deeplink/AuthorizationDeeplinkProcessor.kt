package com.example.authorization_impl.deeplink

import android.content.Context
import android.content.Intent
import com.example.authorization_impl.AuthorizationActivity
import com.example.core_deeplink.DeeplinkProcessor
import javax.inject.Inject

class AuthorizationDeeplinkProcessor @Inject constructor(private val context: Context):DeeplinkProcessor {
    override fun matches(deeplink: String): Boolean {
        return deeplink.contains("/authorization")
    }

    override fun execute(deeplink: String) {
        val intent = Intent(context, AuthorizationActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }
}