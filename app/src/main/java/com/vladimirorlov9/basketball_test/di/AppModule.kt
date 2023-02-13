package com.vladimirorlov9.basketball_test.di

import com.vladimirorlov9.basketball_test.ui.BasketballViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<BasketballViewModel> {
        BasketballViewModel(
            loadLiveMatchesUseCase = get()
        )
    }
}