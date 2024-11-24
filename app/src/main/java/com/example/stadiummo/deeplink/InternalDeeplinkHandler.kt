package com.example.stadiummo.deeplink

import com.example.core_deeplink.DeeplinkHandler
import com.example.core_deeplink.DeeplinkProcessor

class InternalDeeplinkHandler(
    private val processors: Set<@JvmSuppressWildcards DeeplinkProcessor>
) : DeeplinkHandler {
    override fun process(deeplink: String): Boolean {
        processors.forEach {
            if (it.matches(deeplink)) {
                it.execute(deeplink)
                return true
            }
        }
        return false
    }
}