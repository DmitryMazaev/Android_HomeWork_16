package com.example.homework_15

data class PersonModel(
    val results: List<Person>,
    val info: Info
)

data class Person (
    val gender: String,
    val name: Name,
    val email: String,
    val picture: Picture
)
data class Info (
    val seed: String,
    val results: Int,
    val page:Int,
    val version: String
)
data class Name (
    val title: String,
    val first: String,
    val last: String
)
data class Picture (
    val large: String,
    val medium: String,
    val thumbnail: String
)