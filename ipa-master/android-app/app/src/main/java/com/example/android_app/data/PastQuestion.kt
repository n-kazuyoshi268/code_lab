package com.example.android_app.data

data class PastQuestion(val year: String, val name: String)

fun getPastQuestions(): Map<String, List<PastQuestion>> {
    return listOf(
        PastQuestion("2023", "プロジェクトマネージャ試験"),
        PastQuestion("2023", "システムアーキテクト試験"),
        PastQuestion("2022", "ネットワークスペシャリスト試験"),
        PastQuestion("2022", "データベーススペシャリスト試験")
    ).groupBy { it.year }
}
