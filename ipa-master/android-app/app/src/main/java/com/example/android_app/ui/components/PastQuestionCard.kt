package com.example.android_app.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.android_app.data.PastQuestion

@Composable
fun PastQuestionCard(question: PastQuestion, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {
                navController.navigate(
                    "question_detail/${question.year}/${question.name}/${question.section}"
                )
            },
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = question.name)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = question.section)
        }
    }
}
