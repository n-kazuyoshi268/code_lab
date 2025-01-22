package com.example.android_app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.android_app.data.PastQuestion

@Composable
fun QuestionDetailScreen(
    question: PastQuestion,
    onAnswerSelected: (Int) -> Unit,
    selectedAnswer: Int?,
    showExplanation: Boolean
) {
    Column(modifier = Modifier.padding(16.dp)) {
        // 問題文
        Text(
            text = question.questionText,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // 選択肢
        question.choices.forEachIndexed { index, choice ->
            val isSelected = selectedAnswer == index
            val backgroundColor = when {
                isSelected && showExplanation && index == question.correctAnswer -> Color.Green
                isSelected && showExplanation && index != question.correctAnswer -> Color.Red
                else -> Color.Transparent
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .background(backgroundColor)
                    .clickable { onAnswerSelected(index) }
                    .padding(16.dp)
            ) {
                RadioButton(
                    selected = isSelected,
                    onClick = { onAnswerSelected(index) }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = choice)
            }
        }

        // 解説表示
        if (showExplanation) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "解説",
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.primary
            )
            Text(
                text = question.explanation,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}
