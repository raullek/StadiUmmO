package com.example.core_network.di

import com.example.core_network.NetworkApi
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
abstract class CoreNetworkComponent : NetworkApi {
    companion object {
        @Volatile
        private var coreNetworkComponent: CoreNetworkComponent? = null

        fun get(): CoreNetworkComponent {
            if (coreNetworkComponent == null) {
                synchronized(CoreNetworkComponent::class.java) {
                    if (coreNetworkComponent == null) {
                        coreNetworkComponent = DaggerCoreNetworkComponent.builder().build()
                    }
                }
            }
            return coreNetworkComponent!!
        }

    }
}

