package com.example.androidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.androidapp.navigation.AppNavigation
import com.example.androidapp.ui.theme.AndroidAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidAppTheme { // テーマ設定
                AppNavigation() // ナビゲーションの起動
            }
        }
    }
}
