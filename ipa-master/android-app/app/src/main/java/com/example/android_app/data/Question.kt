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

fun getQuestions(year: String, exam: String, section: String): List<Question> {
    return listOf(
        Question(
            id = 1,
            year = "2023",
            exam = "プロジェクトマネージャ試験",
            section = "午前Ⅰ",
            questionText = "この中でプロジェクト管理における重要な要素はどれですか？",
            choices = listOf("品質管理", "資源管理", "スケジュール管理", "全て"),
            correctAnswer = 3,
            explanation = "プロジェクト管理では品質、資源、スケジュール全てが重要です。"
        ),
        Question(
            id = 2,
            year = "2023",
            exam = "プロジェクトマネージャ試験",
            section = "午前Ⅱ",
            questionText = "ウォーターフォールモデルの特性は？",
            choices = listOf("繰り返し型", "段階的進行型", "アジャイル", "スプリント"),
            correctAnswer = 1,
            explanation = "ウォーターフォールモデルは段階的進行型の開発モデルです。"
        )
    ).filter { it.year == year && it.exam == exam && it.section == section }
}
