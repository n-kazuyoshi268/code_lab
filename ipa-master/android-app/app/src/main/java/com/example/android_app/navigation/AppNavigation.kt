package com.example.android_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.android_app.ui.screens.HomeScreen
import com.example.android_app.ui.screens.PastQuestionsScreen
import com.example.android_app.ui.screens.QuestionDetailScreen
import com.example.android_app.ui.screens.PDFReaderScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController, startDestination = "home") {
        // ホーム画面
        composable("home") {
            HomeScreen(navController = navController)
        }

        // 過去問画面
        composable("past_questions") {
            PastQuestionsScreen(navController = navController)
        }

        // 問題詳細画面
        composable(
            route = "question_detail/{questionId}",
            arguments = listOf(
                androidx.navigation.navArgument("questionId") { type = androidx.navigation.NavType.IntType }
            )
        ) { backStackEntry ->
            val questionId = backStackEntry.arguments?.getInt("questionId") ?: 0
            QuestionDetailScreen(questionId = questionId)
        }

        // PDFリーダー画面
        composable("pdf_reader") {
            PDFReaderScreen()
        }
    }
}
