package com.example.stadium_detail_impl.di

import com.example.core_module_injector.BaseDependencies
import com.example.core_module_injector.ComponentHolder
import com.example.core_module_injector.ComponentHolderDelegate
import com.example.stadium_detail_api.StadiumDetailApi

object StadiumDetailComponentHolder : ComponentHolder<StadiumDetailApi, StadiumDetailDependencies> {
    private val componentHolderDelegate =
        ComponentHolderDelegate<StadiumDetailApi, StadiumDetailDependencies, StadiumDetailComponent> { dependencies ->
            StadiumDetailComponent.initAndGet(dependencies)
        }

    internal fun getComponent(): StadiumDetailComponent = componentHolderDelegate.getComponentImpl()

    override var dependencyProvider: (() -> StadiumDetailDependencies)? by componentHolderDelegate::dependencyProvider

    override fun get(): StadiumDetailApi = componentHolderDelegate.get()
}

interface StadiumDetailDependencies : BaseDependencies