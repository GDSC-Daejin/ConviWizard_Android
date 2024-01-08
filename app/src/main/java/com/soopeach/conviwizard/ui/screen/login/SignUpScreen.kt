package com.soopeach.conviwizard.ui.screen.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.soopeach.conviwizard.ui.components.BasicInputTextForm
import com.soopeach.conviwizard.ui.components.Divider
import com.soopeach.conviwizard.viewmodel.SignUpScreenSideEffect
import com.soopeach.conviwizard.viewmodel.SignUpScreenViewModel
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun SignUpScreen(
    navController: NavHostController,
) {

    val viewModel = koinViewModel<SignUpScreenViewModel>()
    val state by viewModel.collectAsState()

    viewModel.collectSideEffect {
        when (it) {
            is SignUpScreenSideEffect.RegisterSuccess -> {
                navController.popBackStack()
            }
        }
    }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .verticalScroll(scrollState),
    ) {

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "회원가입",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.padding(6.dp))
        Divider(
            size = 4
        )
        Spacer(modifier = Modifier.padding(6.dp))

        Text(
            text = "아이디",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.padding(6.dp))

        var idQuery by remember { mutableStateOf("") }

        BasicInputTextForm(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 6.dp),
            value = idQuery, hint = "아이디"
        ) {
            idQuery = it
        }

        Spacer(modifier = Modifier.padding(12.dp))

        Text(
            text = "닉네임",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.padding(6.dp))

        var nickNameQuery by remember { mutableStateOf("") }

        BasicInputTextForm(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 6.dp),
            value = nickNameQuery, hint = "닉네임"
        ) {
            nickNameQuery = it
        }

        Spacer(modifier = Modifier.padding(12.dp))

        Text(
            text = "비밀번호",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.padding(6.dp))

        var passwordQuery by remember { mutableStateOf("") }

        BasicInputTextForm(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 6.dp),
            value = passwordQuery, hint = "비밀번호"
        ) {
            passwordQuery = it
        }

        Spacer(modifier = Modifier.padding(8.dp))

        var passwordCheckQuery by remember { mutableStateOf("") }

        BasicInputTextForm(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 6.dp),
            value = passwordCheckQuery, hint = "비밀번호 확인"
        ) {
            passwordCheckQuery = it
        }

        Spacer(modifier = Modifier.padding(12.dp))

        Text(
            text = "핸드폰번호",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.padding(6.dp))

        var phoneNumQuery by remember { mutableStateOf("") }

        BasicInputTextForm(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 6.dp),
            value = phoneNumQuery, hint = "- 없이 입력해 주세요."
        ) {
            phoneNumQuery = it
        }

        Spacer(modifier = Modifier.padding(12.dp))

        Text(
            text = "이메일",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.padding(6.dp))

        var emailQuery by remember { mutableStateOf("") }

        BasicInputTextForm(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 6.dp),
            value = emailQuery, hint = "이메일"
        ) {
            emailQuery = it
        }

        Spacer(modifier = Modifier.padding(12.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .clip(RoundedCornerShape(16.dp)),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Black,
                contentColor = Color.White
            ),
            onClick = {
                viewModel.postSignUpRequest(
                    emailQuery,
                    idQuery,
                    "name",
                    nickNameQuery,
                    passwordQuery,
                    phoneNumQuery,
                )
            }) {
            Text(
                text = "가입하기",
                style = TextStyle.Default.copy(
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }

        Spacer(modifier = Modifier.padding(10.dp))

    }
}