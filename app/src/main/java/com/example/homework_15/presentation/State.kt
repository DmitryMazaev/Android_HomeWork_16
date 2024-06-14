package com.example.homework_15.presentation

import com.example.homework_15.entity.UsefulActivity

sealed interface State {

    data object Initial: State

    class Success(
        val usefulActivity: String?
    ): State

    class Error(val error: String): State

}