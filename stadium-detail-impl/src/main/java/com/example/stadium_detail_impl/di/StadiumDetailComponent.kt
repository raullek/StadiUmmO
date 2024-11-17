package com.example.stadium_detail_impl.di

import com.example.stadium_detail_api.StadiumDetailApi
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(dependencies = [StadiumDetailDependencies::class])
interface StadiumDetailComponent : StadiumDetailApi {

    companion object {
        fun initAndGet(dependencies: StadiumDetailDependencies): StadiumDetailComponent {
            return DaggerStadiumDetailComponent
                .builder()
                .stadiumDetailDependencies(dependencies)
                .build()
        }
    }
}
