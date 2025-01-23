package com.example.android_app.data

import android.content.Context
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.text.PDFTextStripper
import java.io.IOException

object PDFParser {
    fun parsePDF(context: Context, fileName: String): String? {
        return try {
            // assets から PDF ファイルを取得
            val assetManager = context.assets
            val inputStream = assetManager.open(fileName)

            // PDF を読み込む
            val document = PDDocument.load(inputStream)
            val stripper = PDFTextStripper()
            val text = stripper.getText(document)

            document.close()
            text
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }
}
