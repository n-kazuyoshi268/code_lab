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
            "question_detail/{id}/{section}",
            arguments = listOf(
                androidx.navigation.navArgument("id") { type = androidx.navigation.NavType.IntType },
                androidx.navigation.navArgument("section") { type = androidx.navigation.NavType.StringType }
            )
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            val section = backStackEntry.arguments?.getString("section") ?: ""
            QuestionDetailScreen(id = id, section = section)
        }
    }
}
