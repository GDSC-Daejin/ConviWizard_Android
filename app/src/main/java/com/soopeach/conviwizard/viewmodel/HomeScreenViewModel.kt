package com.soopeach.conviwizard.viewmodel

import androidx.lifecycle.ViewModel
import com.soopeach.conviwizard.domain.model.UiState
import com.soopeach.conviwizard.domain.model.post.PostResponse
import com.soopeach.conviwizard.domain.usecase.GetPostsUseCase
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.viewmodel.container

sealed class HomeScreenSideEffect {

}

data class HomeScreenState(
    val recentPosts: UiState<List<PostResponse>> = UiState.Idle,
    val popularPosts: UiState<List<PostResponse>> = UiState.Idle,
    val recommendedPosts: UiState<List<PostResponse>> = UiState.Idle,
)

class HomeScreenViewModel(
    private val getPostsByCategoryUseCase: GetPostsUseCase
): ViewModel(), ContainerHost<HomeScreenState, HomeScreenSideEffect> {

    override val container: Container<HomeScreenState, HomeScreenSideEffect>
        = container(HomeScreenState())

    fun getPosts(category: Long) = intent {
        val posts = getPostsByCategoryUseCase(category)
    }
}