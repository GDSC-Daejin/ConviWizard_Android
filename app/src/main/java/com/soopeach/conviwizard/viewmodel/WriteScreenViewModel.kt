package com.soopeach.conviwizard.viewmodel

import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModel
import com.soopeach.conviwizard.domain.model.UiState
import com.soopeach.conviwizard.domain.model.post.PostRequest
import com.soopeach.conviwizard.domain.usecase.PostPostUseCase
import com.soopeach.conviwizard.utils.BitmapUtils.getCompressedBitmapFromUri
import com.soopeach.conviwizard.utils.BitmapUtils.saveBitmapToFile
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

sealed class WriteScreenSideEffect {
    data object UploadSuccess : WriteScreenSideEffect()
    data object UploadFailure : WriteScreenSideEffect()
}

data class WriteScreenState(
    val pickedPhoto: UiState<Uri> = UiState.Idle,
)

class WriteScreenViewModel(
    private val postPostUseCase: PostPostUseCase
) : ViewModel(), ContainerHost<WriteScreenState, WriteScreenSideEffect> {

    override val container: Container<WriteScreenState, WriteScreenSideEffect> =
        container(WriteScreenState())

    fun setPickedPhoto(uri: Uri) = intent {
        reduce {
            state.copy(pickedPhoto = UiState.Success(uri))
        }
    }

    fun postPost(
        context: Context,
        combinationName: String,
        combinationContent: String,
        cookingTime: String,
        cookingLevel: String,
        totalPrice: String
    ) = intent {

        val file = state.pickedPhoto.getDataOrNull()?.getCompressedBitmapFromUri(context)
            ?.saveBitmapToFile(context, "conviWizard.jpg")

        val isSuccess = postPostUseCase(
            PostRequest(
                combinationContent,
                cookingLevel.toInt(),
                cookingTime,
                combinationName,
                totalPrice.toInt(),
                (1..3).shuffled().first(),
                1
            ),
            file!!
        )

        postSideEffect(
            if (isSuccess) WriteScreenSideEffect.UploadSuccess
            else WriteScreenSideEffect.UploadFailure
        )

    }
}