package com.example.stadiummo.di

import com.example.core_deeplink.DeeplinkHandler
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DeeplinkModule::class,
        ApplicationModule::class],

    dependencies = [ApplicationDependencies::class]
)
interface ApplicationComponent : ApplicationApi {
    val deeplinkHandler: DeeplinkHandler

    companion object {

        fun initAndGet(dependencies: ApplicationDependencies): ApplicationComponent {
            return DaggerApplicationComponent
                .builder()
                .applicationDependencies(dependencies)
                .build()
        }
    }
}