package com.example.android_app.data

data class PastQuestion(
    val id: Int,
    val year: String,            // 年度
    val name: String,            // 試験名（例: プロジェクトマネージャ試験）
    val section: String,         // セクション（例: 午前Ⅰ）
    val questionText: String,    // 問題文
    val choices: List<String>,   // 選択肢リスト
    val correctAnswer: Int,      // 正解のインデックス
    val explanation: String      // 解説
)

fun getPastQuestions(): Map<String, List<PastQuestion>> {
    return listOf(
        PastQuestion(
            id = 1,
            year = "2023",
            name = "プロジェクトマネージャ試験",
            section = "午前Ⅰ",
            questionText = "この中でプロジェクト管理における重要な要素はどれですか？",
            choices = listOf("品質管理", "資源管理", "スケジュール管理", "全て"),
            correctAnswer = 3,
            explanation = "プロジェクト管理では品質、資源、スケジュール全てが重要です。"
        )
    ).groupBy { it.year }
}