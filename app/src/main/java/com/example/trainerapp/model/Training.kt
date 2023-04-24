package com.example.trainerapp.model

data class Training (
    val id: String,
    val type: String,
    val timeOn: Int,
    val timeOff: Int,
    val rounds: Int,
    val sets: Int,
    val exercises: List<Exercise>
)
