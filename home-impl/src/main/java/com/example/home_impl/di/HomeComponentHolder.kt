package com.example.home_impl.di

import com.example.core_module_injector.BaseDependencies
import com.example.core_module_injector.ComponentHolder
import com.example.core_module_injector.ComponentHolderDelegate
import com.example.home_api.HomeApi

object HomeComponentHolder : ComponentHolder<HomeApi, HomeDependencies> {
    private val componentHolderDelegate =
        ComponentHolderDelegate<HomeApi, HomeDependencies, HomeComponent> { dependencies ->
            HomeComponent.initAndGet(dependencies)
        }

    internal fun getComponent(): HomeComponent = componentHolderDelegate.getComponentImpl()

    override var dependencyProvider: (() -> HomeDependencies)? by componentHolderDelegate::dependencyProvider

    override fun get(): HomeApi = componentHolderDelegate.get()
}

interface HomeDependencies : BaseDependencies {

}