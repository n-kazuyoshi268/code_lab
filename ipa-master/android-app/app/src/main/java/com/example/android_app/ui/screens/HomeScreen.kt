package com.example.android_app.ui.screens
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.android_app.ui.components.MenuCard

@Composable
fun HomeScreen(navController: NavController) {
    val menuItems = listOf(
        "過去問一覧" to "past_questions",
        "学習履歴" to "study_history",
        "模擬試験" to "mock_exam",
        "設定" to "settings",
        "PDF Reader へ移動" to "pdf_reader"
    )

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(menuItems) { (title, route) ->
            MenuCard(title = title) { navController.navigate(route) }
        }
    }
}
