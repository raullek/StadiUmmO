package com.example.stadiummo.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(dependencies = [ApplicationDependencies::class])
interface ApplicationComponent : ApplicationApi {

    companion object {

        fun initAndGet(dependencies: ApplicationDependencies): ApplicationComponent {
            return DaggerApplicationComponent
                .builder()
                .applicationDependencies(dependencies)
                .build()
        }
    }
}