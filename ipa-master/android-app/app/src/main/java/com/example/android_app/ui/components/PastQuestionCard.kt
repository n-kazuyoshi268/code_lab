package com.example.android_app.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
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
            .padding(vertical = 8.dp),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // 試験名
            Text(text = question.name, style = MaterialTheme.typography.subtitle1)
            Spacer(modifier = Modifier.height(8.dp))

            // ボタン群
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                listOf("午前Ⅰ", "午前Ⅱ", "午後Ⅰ", "午後Ⅱ").forEach { section ->
                    Button(
                        onClick = {
                            navController.navigate("question_detail/${question.year}/${question.name}/$section")
                        },
                        modifier = Modifier.weight(1f).padding(horizontal = 4.dp)
                    ) {
                        Text(text = section)
                    }
                }
            }
        }
    }
}
