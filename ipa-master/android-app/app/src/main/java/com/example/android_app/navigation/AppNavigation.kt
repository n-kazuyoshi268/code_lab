package com.example.android_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.android_app.ui.screens.*

@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("past_questions") { PastQuestionsScreen(navController) }
        composable(
            "question_detail/{questionId}",
            arguments = listOf(
                androidx.navigation.navArgument("questionId") { type = androidx.navigation.NavType.IntType }
            )
        ) { backStackEntry ->
            val questionId = backStackEntry.arguments?.getInt("questionId") ?: 0
            QuestionDetailScreen(questionId = questionId)
        }
        composable("pdf_reader") { PDFReaderScreen(context) }
    }
}
