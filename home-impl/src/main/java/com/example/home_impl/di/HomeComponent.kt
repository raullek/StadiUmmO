package com.example.home_impl.di

import com.example.home_api.HomeApi
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(dependencies = [HomeDependencies::class])
interface HomeComponent : HomeApi {

    companion object {
        fun initAndGet(dependencies: HomeDependencies): HomeComponent {
            return DaggerHomeComponent
                .builder()
                .homeDependencies(dependencies)
                .build()
        }
    }
}