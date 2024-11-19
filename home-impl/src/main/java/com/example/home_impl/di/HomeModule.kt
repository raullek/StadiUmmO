package com.example.home_impl.di

import com.example.home_api.HomeLauncher
import com.example.home_impl.HomeLauncherImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class HomeModule {

    @Singleton
    @Provides
    fun provideFeatureLauncher(): HomeLauncher = HomeLauncherImpl()

}