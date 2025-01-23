package com.example.android_app.data

data class Question(
    val id: Int,
    val year: String,
    val exam: String,
    val section: String,
    val questionText: String,
    val choices: List<String>,
    val correctAnswer: Int, // 正解の選択肢インデックス (0-based)
    val explanation: String // 解説
)

