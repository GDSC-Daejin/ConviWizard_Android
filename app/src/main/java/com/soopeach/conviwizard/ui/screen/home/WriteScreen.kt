package com.soopeach.conviwizard.ui.screen.home

import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.soopeach.conviwizard.ui.components.BasicInputTextForm
import com.soopeach.conviwizard.utils.BitmapUtils.getCompressedBitmapFromUri
import com.soopeach.conviwizard.viewmodel.WriteScreenSideEffect
import com.soopeach.conviwizard.viewmodel.WriteScreenViewModel
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun WriteScreen(
    navController: NavHostController,
) {

    val context = LocalContext.current
    val viewModel = koinViewModel<WriteScreenViewModel>()
    val state by viewModel.collectAsState()

    viewModel.collectSideEffect {
        when (it) {
            is WriteScreenSideEffect.UploadSuccess -> {
                navController.popBackStack()
            }

            is WriteScreenSideEffect.UploadFailure -> {
                Toast.makeText(context, "조합 등록에 실패하였습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    val scrollState = rememberScrollState()

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri ->
            uri?.let {
                viewModel.setPickedPhoto(it)
            }
        }
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .verticalScroll(scrollState),
    ) {

        Text(
            text = "조합 이름",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.padding(6.dp))

        var combinationName by remember { mutableStateOf("") }

        BasicInputTextForm(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 6.dp),
            value = combinationName, hint = "조합의 이름을 알려주세요."
        ) {
            combinationName = it
        }

        Spacer(modifier = Modifier.padding(12.dp))

        Text(
            text = "조합 방법",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.padding(6.dp))

        var combinationContent by remember { mutableStateOf("") }

        BasicInputTextForm(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 6.dp),
            value = combinationContent, hint = "조합을 만드는 방법을 알려주세요."
        ) {
            combinationContent = it
        }

        Spacer(modifier = Modifier.padding(12.dp))

        Text(
            text = "조합 시간",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.padding(6.dp))

        var cookingTime by remember { mutableStateOf("") }

        BasicInputTextForm(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 6.dp),
            value = cookingTime, hint = "조합을 만드는데 걸리는 시간(분)을 알려주세요."
        ) {
            cookingTime = it
        }

        Spacer(modifier = Modifier.padding(12.dp))

        Text(
            text = "조합 난이도",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.padding(6.dp))

        var cookingLevel by remember { mutableStateOf("") }

        BasicInputTextForm(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 6.dp),
            value = cookingLevel, hint = "조합의 난이도를 알려주세요."
        ) {
            cookingLevel = it
        }

        Spacer(modifier = Modifier.padding(12.dp))

        Text(
            text = "조합 비용",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.padding(6.dp))

        var totalPrice by remember { mutableStateOf("") }

        BasicInputTextForm(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 6.dp),
            value = totalPrice, hint = "조합의 비용을 알려주세요."
        ) {
            totalPrice = it
        }

        Spacer(modifier = Modifier.padding(24.dp))

        Text(
            text = "조합 사진",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.padding(6.dp))

        state.pickedPhoto.getDataOrNull()?.let { pickedPhotoUri ->

            Image(
                bitmap = requireNotNull(pickedPhotoUri.getCompressedBitmapFromUri(context)).asImageBitmap(),
                contentDescription = "선택된 사진"
            )

        } ?: run {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(color = Color.LightGray.copy(alpha = 0.8f))
                    .padding(6.dp)
                    .clickable {
                        launcher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
                    },
                contentAlignment = Alignment.Center
            ) {
                Icon(imageVector = Icons.Filled.AddCircle, contentDescription = "추가 버튼")
            }
        }


        Spacer(modifier = Modifier.padding(24.dp))

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Button(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .clip(RoundedCornerShape(16.dp)),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFF74C5F7),
                    contentColor = Color.Black
                ),
                onClick = {
                    viewModel.postPost(
                        context,
                        combinationName,
                        combinationContent,
                        cookingTime,
                        cookingLevel,
                        totalPrice
                    )
                }) {
                Text(
                    text = "조합 등록하기",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

