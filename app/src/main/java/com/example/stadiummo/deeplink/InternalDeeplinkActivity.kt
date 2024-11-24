package com.example.stadiummo.deeplink

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.core_deeplink.DeeplinkHandler
import com.example.stadiummo.di.ApplicationComponentHolder

class InternalDeeplinkActivity : ComponentActivity() {
    private var deeplinkHandler: DeeplinkHandler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        deeplinkHandler = ApplicationComponentHolder.getComponent().deeplinkHandler

        intent?.let {
            handleIntent(it)
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent) {
        intent.data?.toString()?.let {
            deeplinkHandler?.process(it)
            finish()
        }

    }
}