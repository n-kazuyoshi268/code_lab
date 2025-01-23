package com.example.android_app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun QuestionDetailScreen(year: String, name: String, section: String) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "年度: $year", modifier = Modifier.padding(bottom = 8.dp))
        Text(text = "試験名: $name", modifier = Modifier.padding(bottom = 8.dp))
        Text(text = "セクション: $section", modifier = Modifier.padding(bottom = 8.dp))
    }
}
