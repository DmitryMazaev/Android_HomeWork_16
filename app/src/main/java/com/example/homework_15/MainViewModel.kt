package com.example.homework_15
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel () : ViewModel() {
    private val _state = MutableStateFlow<State>(State.Initial)
    val state = _state.asStateFlow()

    val apiService by lazy {
        RetrofitHelepr.retrofitEngine.create(RandomuserApiService::class.java)
    }

    fun start() {
       // state.value = State.Loading
        viewModelScope.launch(Dispatchers.IO) {
            val result = apiService.getSuspend()
            val users = result.results
            val newState = State.Success(users)
            _state.value = newState
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}