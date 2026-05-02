package com.example.lr11mobpri

import android.os.Bundle
import com.example.lr11mobpri.presentation.posts.PostsScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // ViewModel будет получена через hiltViewModel() внутри экрана
            PostsScreen()
        }
    }
}