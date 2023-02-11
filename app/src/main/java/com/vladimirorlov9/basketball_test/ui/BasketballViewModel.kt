package com.vladimirorlov9.basketball_test.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vladimirorlov9.basketball_test.domain.model.LiveMatch
import com.vladimirorlov9.basketball_test.domain.usecase.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BasketballViewModel(
    private val loadLiveMatchesUseCase: LoadLiveMatchesUseCase
) : ViewModel() {

    private val _liveMatchesLD = MutableLiveData<List<LiveMatch>>()
    val liveMatchesLD: LiveData<List<LiveMatch>> = _liveMatchesLD

    fun getLiveMatches() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = loadLiveMatchesUseCase.execute()

            launch(Dispatchers.Main) {
                _liveMatchesLD.value = result
            }
        }
    }
}