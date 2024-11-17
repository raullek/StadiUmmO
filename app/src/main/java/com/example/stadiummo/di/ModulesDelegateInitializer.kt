package com.example.stadiummo.di

import com.example.authorization_impl.di.AuthorizationComponentHolder
import com.example.authorization_impl.di.AuthorizationDependencies
import com.example.core_module_injector.BaseDependencies
import com.example.core_module_injector.BaseDependencyHolder
import com.example.core_module_injector.DependencyHolder0
import com.example.home_impl.di.HomeComponentHolder
import com.example.home_impl.di.HomeDependencies
import com.example.stadium_detail_impl.di.StadiumDetailComponentHolder
import com.example.stadium_detail_impl.di.StadiumDetailDependencies

object ModulesDelegateInitializer {

    fun initialize() {
        /**
         * App module di initializer
         */

        ApplicationComponentHolder.dependencyProvider = {
            class ApplicationComponentHolder(
                override val block: (BaseDependencyHolder<ApplicationDependencies>) -> ApplicationDependencies
            ) : DependencyHolder0<ApplicationDependencies>()

            ApplicationComponentHolder { dependencyHolder ->
                object : ApplicationDependencies {
                    override val dependencyHolder: BaseDependencyHolder<out BaseDependencies> = dependencyHolder
                }
            }.dependencies
        }

        /**
         * Authorization Module delegate
         */
        AuthorizationComponentHolder.dependencyProvider = {
            class AuthorizationComponentHolder(
                override val block: (BaseDependencyHolder<AuthorizationDependencies>) -> AuthorizationDependencies
            ) : DependencyHolder0<AuthorizationDependencies>()

            AuthorizationComponentHolder { dependencyHolder ->
                object : AuthorizationDependencies {
                    override val dependencyHolder: BaseDependencyHolder<out BaseDependencies> = dependencyHolder
                }
            }.dependencies
        }

        /**
         * Home module delegate
         */
        HomeComponentHolder.dependencyProvider = {
            class HomeComponentHolder(
                override val block: (BaseDependencyHolder<HomeDependencies>) -> HomeDependencies
            ) : DependencyHolder0<HomeDependencies>()

            HomeComponentHolder { dependencyHolder ->
                object : HomeDependencies {
                    override val dependencyHolder: BaseDependencyHolder<out BaseDependencies> = dependencyHolder
                }
            }.dependencies
        }

        /**
         * Stadium detail module delegate
         */
        StadiumDetailComponentHolder.dependencyProvider = {
            class StadiumDetailComponentHolder(
                override val block: (BaseDependencyHolder<StadiumDetailDependencies>) -> StadiumDetailDependencies
            ) : DependencyHolder0<StadiumDetailDependencies>()

            StadiumDetailComponentHolder { dependencyHolder ->
                object : StadiumDetailDependencies {
                    override val dependencyHolder: BaseDependencyHolder<out BaseDependencies> = dependencyHolder
                }
            }.dependencies
        }








    }
}