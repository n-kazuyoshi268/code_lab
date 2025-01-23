package com.example.android_app.data

object SampleData {
    private val questions = listOf(
        Question(
            id = 1,
            exam = "2023年度 プロジェクトマネージャ試験",
            section = "午後Ⅰ",
            questionText = "プロジェクト管理における重要な要素はどれですか？",
            choices = listOf("品質管理", "資源管理", "スケジュール管理", "全て"),
            correctAnswer = "全て",
            explanation = "プロジェクト管理では品質、資源、スケジュール全てが重要です。"
        ),
        Question(
            id = 2,
            exam = "2023年度 システムアーキテクト試験",
            section = "午後Ⅱ",
            questionText = "システム設計において考慮すべき最も重要な要素はどれですか？",
            choices = listOf("性能", "拡張性", "セキュリティ", "全て"),
            correctAnswer = "全て",
            explanation = "システム設計では性能、拡張性、セキュリティ全てを考慮する必要があります。"
        )
    )

    fun getQuestionById(id: Int): Question {
        return questions.first { it.id == id }
    }
}
