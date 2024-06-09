package com.example.homework_15

sealed interface State {

    data object Initial: State

    class Success(
        val users: List<Person>
    ): State

    class Error(val error: String): State

}