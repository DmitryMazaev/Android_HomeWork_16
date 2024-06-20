package com.example.homework_15.presentation
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework_15.data.RetrofitHelepr
import com.example.homework_15.data.UsefulActivitiesRepository
import com.example.homework_15.domain.GetUsefulActivityUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel (private val getUsefulActivityUseCase: GetUsefulActivityUseCase) : ViewModel() {
    private val _state = MutableStateFlow<State>(State.Initial)
    val state = _state.asStateFlow()

    fun start() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getUsefulActivityUseCase.execute()
            val usefulActivity = result.activity
            val newState = State.Success(usefulActivity)
            _state.value = newState
        }
    }
    suspend fun getExercise(getUsefulActivityUseCase: GetUsefulActivityUseCase):String {
        return getUsefulActivityUseCase.execute().toString()
    }

    override fun onCleared() {
        super.onCleared()
    }
}