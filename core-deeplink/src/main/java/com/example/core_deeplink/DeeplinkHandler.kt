package com.example.core_deeplink

interface DeeplinkHandler {
    fun process(deeplink: String): Boolean
}