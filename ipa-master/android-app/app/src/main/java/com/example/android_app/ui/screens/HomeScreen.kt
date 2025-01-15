package com.example.androidapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.androidapp.ui.components.MenuCard

@Composable
fun HomeScreen(navController: NavController) {
    val menuItems = listOf(
        "過去問一覧" to "past_questions",
        "学習履歴" to "study_history",
        "模擬試験" to "mock_exam",
        "設定" to "settings"
    )

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        androidx.compose.material.Text(
            text = "IPA試験対策アプリ",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 24.dp)
        )
        LazyColumn {
            items(menuItems.size) { index ->
                val (title, route) = menuItems[index]
                MenuCard(title = title) {
                    navController.navigate(route)
                }
            }
        }
    }
}
