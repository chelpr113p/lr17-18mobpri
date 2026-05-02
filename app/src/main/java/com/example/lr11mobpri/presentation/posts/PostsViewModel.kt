package com.example.lr11mobpri.presentation.posts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lr11mobpri.domain.usecase.AddPostUseCase
import com.example.lr11mobpri.domain.usecase.GetPostsUseCase
import com.example.lr11mobpri.domain.service.GreetingService
import com.example.lr11mobpri.di.MorningGreeting
import com.example.lr11mobpri.di.EveningGreeting
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase,
    private val addPostUseCase: AddPostUseCase,
    @MorningGreeting private val morningGreeting: GreetingService,
    @EveningGreeting private val eveningGreeting: GreetingService
) : ViewModel() {

    init {
        android.util.Log.d("GreetingTest", morningGreeting.getGreeting())
        android.util.Log.d("GreetingTest", eveningGreeting.getGreeting())
    }

    private val _uiState = MutableStateFlow(PostsUiState())
    val uiState: StateFlow<PostsUiState> = _uiState.asStateFlow()

    fun loadPosts(page: Int = 1, limit: Int = 20) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }
            getPostsUseCase(page, limit)
                .onSuccess { posts ->
                    _uiState.update { it.copy(posts = posts, isLoading = false) }
                }
                .onFailure { e ->
                    _uiState.update { it.copy(isLoading = false, error = e.message) }
                }
        }
    }

    fun addPost(title: String, body: String) {
        if (title.isBlank()) return
        val newPost = com.example.lr11mobpri.domain.model.Post(
            id = 0, userId = 1, title = title, body = body
        )
        viewModelScope.launch {
            addPostUseCase(newPost)
                .onSuccess { loadPosts() }
                .onFailure { e ->
                    _uiState.update { it.copy(error = e.message) }
                }
        }
    }

    fun clearError() {
        _uiState.update { it.copy(error = null) }
    }
}