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
            "question_detail/{year}/{name}/{section}",
            arguments = listOf(
                androidx.navigation.navArgument("year") { type = androidx.navigation.NavType.StringType },
                androidx.navigation.navArgument("name") { type = androidx.navigation.NavType.StringType },
                androidx.navigation.navArgument("section") { type = androidx.navigation.NavType.StringType }
            )
        ) { backStackEntry ->
            val year = backStackEntry.arguments?.getString("year") ?: ""
            val name = backStackEntry.arguments?.getString("name") ?: ""
            val section = backStackEntry.arguments?.getString("section") ?: ""
            QuestionDetailScreen(year = year, name = name, section = section)
        }
    }
}
