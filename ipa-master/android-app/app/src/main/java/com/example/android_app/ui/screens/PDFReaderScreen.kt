package com.example.android_app.ui.screens

import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.android_app.data.PDFParser

@Composable
fun PDFReaderScreen(context: Context) {
    var pdfText by remember { mutableStateOf("") }

    // PDF を読み込むボタン
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(
            onClick = {
                val text = PDFParser.parsePDF(context, "sample_question.pdf")
                pdfText = text ?: "PDF の読み込みに失敗しました"
                Log.d("PDFReader", pdfText)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("PDF を読み込む")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 読み込んだテキストを表示
        Text(text = pdfText, modifier = Modifier.fillMaxWidth())
    }
}
