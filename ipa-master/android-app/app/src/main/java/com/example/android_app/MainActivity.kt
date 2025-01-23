package com.example.android_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.android_app.navigation.AppNavigation
import com.example.android_app.ui.theme.AndroidAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidAppTheme {
                val navController = rememberNavController()
                AppNavigation(navController = navController, context = this)
            }
        }
    }
}
