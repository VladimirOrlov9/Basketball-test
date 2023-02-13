package com.vladimirorlov9.basketball_test.di

import com.vladimirorlov9.basketball_test.data.api.retrofit2.AllSportsApiService
import com.vladimirorlov9.basketball_test.data.repository.BasketballRepositoryImpl
import com.vladimirorlov9.basketball_test.domain.repository.BasketballRepository
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(AllSportsApiService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<AllSportsApiService> {
        val retrofit = get<Retrofit>()
        retrofit.create(AllSportsApiService::class.java)
    }


    single<BasketballRepository> {
        BasketballRepositoryImpl(
            allSportsApiService = get()
        )
    }
}