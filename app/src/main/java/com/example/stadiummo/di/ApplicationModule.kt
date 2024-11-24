package com.example.stadiummo.di

import com.example.core_deeplink.DeeplinkHandler
import com.example.core_deeplink.DeeplinkProcessor
import com.example.stadiummo.deeplink.InternalDeeplinkHandler
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    @Singleton
    fun providesDefaultDeeplinkHandler(
        processors: Set<@JvmSuppressWildcards DeeplinkProcessor>
    ): DeeplinkHandler = InternalDeeplinkHandler(processors)

}