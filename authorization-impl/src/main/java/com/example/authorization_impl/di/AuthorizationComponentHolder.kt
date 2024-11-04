package com.example.authorization_impl.di

import com.example.authorization_api.AuthorizationApi
import com.example.core_module_injector.BaseDependencies
import com.example.core_module_injector.ComponentHolder
import com.example.core_module_injector.ComponentHolderDelegate

object AuthorizationComponentHolder : ComponentHolder<AuthorizationApi, AuthorizationDependencies> {
    private val componentHolderDelegate =
        ComponentHolderDelegate<AuthorizationApi, AuthorizationDependencies, AuthorizationComponent> { dependencies ->
            AuthorizationComponent.initAndGet(dependencies)
        }

    internal fun getComponent(): AuthorizationComponent = componentHolderDelegate.getComponentImpl()

    override var dependencyProvider: (() -> AuthorizationDependencies)? by componentHolderDelegate::dependencyProvider

    override fun get(): AuthorizationApi = componentHolderDelegate.get()
}

interface AuthorizationDependencies : BaseDependencies {

}