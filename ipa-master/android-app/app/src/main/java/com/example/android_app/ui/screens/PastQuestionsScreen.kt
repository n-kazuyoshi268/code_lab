package com.example.android_app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.android_app.ui.components.PastQuestionCard
import com.example.android_app.ui.components.PastQuestion

@Composable
fun PastQuestionsScreen(navController: NavController) {
    // サンプルデータ
    val sampleQuestions = listOf(
        PastQuestion(1, "2023年度 プロジェクトマネージャ試験"),
        PastQuestion(2, "2023年度 システムアーキテクト試験"),
        PastQuestion(3, "2022年度 ネットワークスペシャリスト試験"),
        PastQuestion(4, "2022年度 データベーススペシャリスト試験")
    )

    // 過去問リストの表示
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(sampleQuestions) { question ->
            PastQuestionCard(
                pastQuestion = question,
                onAfternoon1Click = {
                    navController.navigate("question_detail/${question.id}/afternoon1")
                },
                onAfternoon2Click = {
                    navController.navigate("question_detail/${question.id}/afternoon2")
                }
            )
        }
    }
}
