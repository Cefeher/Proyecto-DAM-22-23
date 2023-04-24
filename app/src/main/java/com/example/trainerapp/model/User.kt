package com.example.trainerapp.model

data class User (
    val id: String,
    val name: String,
    val email: String,
    val password: String,
    val favorites: List<Training>
)

