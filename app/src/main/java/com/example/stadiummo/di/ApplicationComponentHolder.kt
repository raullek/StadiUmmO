package com.example.stadiummo.di

import android.content.Context
import com.example.core_module_injector.BaseAPI
import com.example.core_module_injector.BaseDependencies
import com.example.core_module_injector.ComponentHolder
import com.example.core_module_injector.ComponentHolderDelegate

object ApplicationComponentHolder : ComponentHolder<ApplicationApi, ApplicationDependencies> {
    private val componentHolderDelegate =
        ComponentHolderDelegate<ApplicationApi, ApplicationDependencies, ApplicationComponent> { dependencies ->
            ApplicationComponent.initAndGet(dependencies)
        }

    internal fun getComponent(): ApplicationComponent = componentHolderDelegate.getComponentImpl()

    override var dependencyProvider: (() -> ApplicationDependencies)? by componentHolderDelegate::dependencyProvider

    override fun get(): ApplicationApi = componentHolderDelegate.get()
}

interface ApplicationDependencies : BaseDependencies {
    val context: Context

}

interface ApplicationApi : BaseAPI