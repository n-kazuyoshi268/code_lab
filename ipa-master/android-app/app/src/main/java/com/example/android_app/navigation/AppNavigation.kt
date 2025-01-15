package com.example.androidapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidapp.ui.screens.*
import com.example.ipaexam.ui.screens.PastQuestionsScreen
import com.example.ipaexam.ui.screens.SettingsScreen
import com.example.ipaexam.ui.screens.StudyHistoryScreen
import com.example.ipaexam.ui.screens.MockExamScreen

@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("past_questions") { PastQuestionsScreen() }
        composable("study_history") { StudyHistoryScreen() }
        composable("mock_exam") { MockExamScreen() }
        composable("settings") { SettingsScreen() }
    }
}
