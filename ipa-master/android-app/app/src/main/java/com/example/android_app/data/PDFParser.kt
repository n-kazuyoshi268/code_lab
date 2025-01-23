//package com.example.android_app.data
//
//import org.apache.pdfbox.pdmodel.PDDocument
//import org.apache.pdfbox.text.PDFTextStripper
//import java.io.InputStream
//
//object PDFParser {
//    fun parse(inputStream: InputStream): List<Question> {
//        val document = PDDocument.load(inputStream)
//        val text = PDFTextStripper().apply {
//            startPage = 1
//            endPage = document.numberOfPages
//        }.getText(document)
//        document.close()
//
//        // 正規表現で解析（仮の実装）
//        val questions = mutableListOf<Question>()
//        val regex = Regex("Q\\d+\\..*?\\n(?:.*?\\n)*?Answer:.*")
//        regex.findAll(text).forEachIndexed { index, matchResult ->
//            val questionText = matchResult.value
//            questions.add(
//                Question(
//                    id = index + 1,
//                    text = questionText,
//                    options = listOf("Option A", "Option B", "Option C", "Option D"), // 仮の選択肢
//                    correctAnswer = "A" // 仮の正解
//                )
//            )
//        }
//
//        return questions
//    }
//}
