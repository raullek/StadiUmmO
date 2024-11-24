package com.example.core_deeplink

interface DeeplinkProcessor {
    fun matches(deeplink: String): Boolean

    fun execute(deeplink: String)
}