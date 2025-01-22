package com.example.android_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.android_app.data.getSampleQuestions
import com.example.android_app.ui.screens.*

@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()
    val sampleQuestions = getSampleQuestions()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("past_questions") { PastQuestionsScreen(navController) }
        composable("question_detail") {
            val question = sampleQuestions.first()
            QuestionDetailScreen(
                question = question,
                onAnswerSelected = {},
                selectedAnswer = null,
                showExplanation = false
            )
        }
    }
}
