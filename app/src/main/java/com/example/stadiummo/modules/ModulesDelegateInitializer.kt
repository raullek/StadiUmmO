package com.example.stadiummo.modules

import android.content.Context
import com.example.authorization_impl.di.AuthorizationComponentHolder
import com.example.authorization_impl.di.AuthorizationDependencies
import com.example.core_module_injector.BaseDependencies
import com.example.core_module_injector.BaseDependencyHolder
import com.example.core_module_injector.DependencyHolder0
import com.example.core_module_injector.DependencyHolder1
import com.example.home_api.HomeApi
import com.example.home_api.HomeLauncher
import com.example.home_impl.di.HomeComponentHolder
import com.example.home_impl.di.HomeDependencies
import com.example.stadium_detail_impl.di.StadiumDetailComponentHolder
import com.example.stadium_detail_impl.di.StadiumDetailDependencies
import com.example.stadiummo.StadiumoApp
import com.example.stadiummo.di.ApplicationComponentHolder
import com.example.stadiummo.di.ApplicationDependencies

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
                    override val context: Context = StadiumoApp.getContext()
                    override val dependencyHolder: BaseDependencyHolder<out BaseDependencies> = dependencyHolder
                }
            }.dependencies
        }

        /**
         * Authorization Module delegate
         */
        AuthorizationComponentHolder.dependencyProvider = {
            class AuthorizationComponentHolder(
                override val block: (BaseDependencyHolder<AuthorizationDependencies>, HomeApi) -> AuthorizationDependencies
            ) : DependencyHolder1<HomeApi,AuthorizationDependencies>(
                api1 =HomeComponentHolder.get()
            )

            AuthorizationComponentHolder { dependencyHolder, homeApi->
                object : AuthorizationDependencies {
                    override val homeApi: HomeLauncher = homeApi.launcher
                    override val dependencyHolder: BaseDependencyHolder<out BaseDependencies>
                        get() = dependencyHolder
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