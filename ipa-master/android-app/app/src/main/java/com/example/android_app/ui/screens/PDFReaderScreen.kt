package com.example.android_app.ui.screens

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.text.PDFTextStripper
import java.io.InputStream

@Composable
fun PDFReaderScreen() {
    var pdfContent by remember { mutableStateOf("") }

    // ファイルピッカーのランチャーをセットアップ
    val context = LocalContext.current
    val pdfPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocument()
    ) { uri: Uri? ->
        uri?.let {
            pdfContent = readPdf(context, it) ?: "PDFを読み込めませんでした"
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "PDF Reader",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Button(onClick = { pdfPickerLauncher.launch(arrayOf("application/pdf")) }) {
            Text("PDFを読み込む")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (pdfContent.isNotEmpty()) {
            Text(
                text = pdfContent,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}

fun readPdf(context: Context, uri: Uri): String? {
    return try {
        context.contentResolver.openInputStream(uri)?.use { inputStream ->
            val document = PDDocument.load(inputStream)
            val pdfText = PDFTextStripper().getText(document)
            document.close()
            pdfText
        }
    } catch (e: Exception) {
        Log.e("PDFReader", "PDFの読み込みに失敗しました: ${e.message}")
        null
    }
}
