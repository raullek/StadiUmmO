package com.example.stadiummo.di

import com.example.authorization_impl.deeplink.AuthorizationDeeplinkProcessor
import com.example.core_deeplink.DeeplinkProcessor
import com.example.home_impl.deeplink.HomeDeeplinkProcessor
import com.example.stadium_detail_impl.deeplink.StadiumDetailDeeplinkProcessor
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet
import javax.inject.Singleton

@Module
abstract class DeeplinkModule {

    @Binds
    @Singleton
    @IntoSet
    abstract fun authorizationProcessor(authorizationProcessor: AuthorizationDeeplinkProcessor):DeeplinkProcessor

    @Binds
    @Singleton
    @IntoSet
    abstract fun homeProcessor(homeProcessor: HomeDeeplinkProcessor):DeeplinkProcessor

    @Binds
    @Singleton
    @IntoSet
    abstract fun stadiumDetailProcessor(stadiumDetailProcessor: StadiumDetailDeeplinkProcessor):DeeplinkProcessor


}