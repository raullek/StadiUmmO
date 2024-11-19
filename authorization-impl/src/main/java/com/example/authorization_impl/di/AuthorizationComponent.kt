package com.example.authorization_impl.di

import com.example.authorization_api.AuthorizationApi
import com.example.home_api.HomeLauncher
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(dependencies = [AuthorizationDependencies::class])
interface AuthorizationComponent : AuthorizationApi {
    val homeLauncher:HomeLauncher

    companion object {
        fun initAndGet(dependencies: AuthorizationDependencies): AuthorizationComponent {
            return DaggerAuthorizationComponent
                .builder()
                .authorizationDependencies(dependencies)
                .build()
        }
    }
}