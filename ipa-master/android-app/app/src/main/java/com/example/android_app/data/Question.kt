package com.example.android_app.data

data class Question(
    val id: Int,
    val exam: String,
    val section: String,
    val questionText: String,
    val choices: List<String>,
    val correctAnswer: String,
    val explanation: String
)
