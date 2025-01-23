package com.example.android_app.data

object SampleData {
    val sampleQuestion = PastQuestion(
        id = 1,
        year = "2023",
        name = "プロジェクトマネージャ試験",
        section = "午前Ⅰ",
        questionText = "この中でプロジェクト管理における重要な要素はどれですか？",
        choices = listOf("品質管理", "資源管理", "スケジュール管理", "全て"),
        correctAnswer = 3,
        explanation = "プロジェクト管理では品質、資源、スケジュール全てが重要です。"
    )
}
