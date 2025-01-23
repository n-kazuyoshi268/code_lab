package com.example.android_app.ui.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.github.barteksc.pdfviewer.PDFView
import com.example.android_app.data.Question

@Composable
fun QuestionDetailScreen(questionId: Int) {
    var selectedPdfUri by remember { mutableStateOf<Uri?>(null) }
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        selectedPdfUri = uri
    }

    val question = remember { getQuestionById(questionId) }

    Column(modifier = Modifier.fillMaxSize()) {
        PDFViewerSection(
            selectedPdfUri = selectedPdfUri,
            onSelectPdf = { launcher.launch("application/pdf") }
        )

        Divider(modifier = Modifier.padding(vertical = 8.dp))

        AnswerInputSection(question = question)
    }
}

@Composable
fun PDFViewerSection(selectedPdfUri: Uri?, onSelectPdf: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = onSelectPdf,
            modifier = Modifier.padding(16.dp)
        ) {
            Text("PDFを選択")
        }

        selectedPdfUri?.let { uri ->
            AndroidView(
                factory = { context ->
                    PDFView(context, null).apply {
                        fromUri(uri).load()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )
        } ?: Text(
            text = "PDFが選択されていません",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun AnswerInputSection(question: Question) {
    var answer by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("問題: ${question.questionText}")
        TextField(
            value = answer,
            onValueChange = { answer = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("回答を入力") }
        )
        Button(
            onClick = { println("回答送信: $answer") },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("回答を送信")
        }
    }
}

fun getQuestionById(id: Int): Question {
    return Question(
        id = id,
        exam = "サンプル試験",
        section = "サンプルセクション",
        questionText = "サンプル問題文",
        choices = listOf("選択肢1", "選択肢2", "選択肢3", "選択肢4"),
        correctAnswer = "選択肢1",
        explanation = "サンプル解説"
    )
}
