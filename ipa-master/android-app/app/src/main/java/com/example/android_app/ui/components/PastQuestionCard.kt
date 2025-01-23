package com.example.android_app.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PastQuestionCard(
    pastQuestion: PastQuestion,
    onAfternoon1Click: () -> Unit,
    onAfternoon2Click: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = pastQuestion.title,
                style = MaterialTheme.typography.h6
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = onAfternoon1Click,
                    modifier = Modifier.weight(1f)
                ) {
                    Text("午後Ⅰ")
                }
                Button(
                    onClick = onAfternoon2Click,
                    modifier = Modifier.weight(1f)
                ) {
                    Text("午後Ⅱ")
                }
            }
        }
    }
}

// サンプルデータ用のデータクラス
data class PastQuestion(
    val id: Int,
    val title: String
)
