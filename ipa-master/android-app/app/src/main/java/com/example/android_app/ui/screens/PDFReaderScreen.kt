package com.example.android_app.ui.screens

import android.gesture.GestureLibraries.fromFile
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
import java.io.File

@Composable
fun PDFReaderScreen() {
    var selectedPdfUri by remember { mutableStateOf<Uri?>(null) }

    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        selectedPdfUri = uri
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { launcher.launch("application/pdf") },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("PDFを選択")
        }

        Spacer(modifier = Modifier.height(16.dp))

        selectedPdfUri?.let { uri ->
            PDFViewer(uri = uri)
        }
    }
}

@Composable
fun PDFViewer(uri: Uri) {
    AndroidView(
        factory = { context ->
            PDFView(context, null).apply {
                // AndroidでUriをFileに変換
                val file = File(context.cacheDir, "temp_pdf.pdf").apply {
                    context.contentResolver.openInputStream(uri)?.use { inputStream ->
                        outputStream().use { outputStream ->
                            inputStream.copyTo(outputStream)
                        }
                    }
                }

                // FileオブジェクトをPDFViewに渡す
                fromFile(file).load()
            }
        },
        modifier = Modifier.fillMaxSize()
    )
}
