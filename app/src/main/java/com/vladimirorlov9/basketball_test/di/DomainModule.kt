package com.vladimirorlov9.basketball_test.di

import com.vladimirorlov9.basketball_test.domain.usecase.LoadLiveMatchesUseCase
import org.koin.dsl.module

val domainModule = module {
    factory {
        LoadLiveMatchesUseCase(
            basketballRepository = get()
        )
    }
}