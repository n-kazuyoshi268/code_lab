package com.example.android_app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_app.data.Question
import com.example.android_app.data.SampleData

@Composable
fun QuestionDetailScreen(questionId: Int) {
    val question: Question = SampleData.getQuestionById(questionId)
    val scrollState = rememberScrollState()
    var userAnswer by remember { mutableStateOf("") }
    var showResult by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {
        // 試験名と分野
        Text(
            text = "試験: ${question.exam}",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "分野: ${question.section}",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // 問題文
        Text(
            text = "問題文:",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = question.questionText,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // 回答欄
        Text(
            text = "回答を入力してください:",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = userAnswer,
            onValueChange = { userAnswer = it },
            label = { Text("回答") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        // 回答ボタン
        Button(
            onClick = { showResult = true },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("回答する")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 正解と解説（回答後に表示）
        if (showResult) {
            Text(
                text = "正解: ${question.correctAnswer}",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = if (userAnswer == question.correctAnswer) Color.Green else Color.Red,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = if (userAnswer == question.correctAnswer) "正解です！" else "不正解です。",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = if (userAnswer == question.correctAnswer) Color.Green else Color.Red,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "解説:",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = question.explanation,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
    }
}
