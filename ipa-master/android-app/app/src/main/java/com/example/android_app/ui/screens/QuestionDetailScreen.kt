package com.example.android_app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun QuestionDetailScreen(id: Int, section: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "問題ID: $id", modifier = Modifier.padding(bottom = 8.dp))
        Text(text = "セクション: $section", modifier = Modifier.padding(bottom = 8.dp))
        // ここに問題の詳細や選択肢を表示するコードを追加
    }
}
