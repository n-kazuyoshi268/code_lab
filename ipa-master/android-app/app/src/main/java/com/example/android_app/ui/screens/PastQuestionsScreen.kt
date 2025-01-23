package com.example.android_app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.android_app.data.PastQuestion
import com.example.android_app.data.getPastQuestions
import com.example.android_app.ui.components.PastQuestionCard

@Composable
fun PastQuestionsScreen(navController: NavController) {
    val questionsByYear = getPastQuestions()

    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        questionsByYear.forEach { (year, questions) ->
            item {
                Text(
                    text = "$year 年度",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
            items(questions) { question ->
                PastQuestionCard(question = question, navController = navController)
            }
        }
    }
}
