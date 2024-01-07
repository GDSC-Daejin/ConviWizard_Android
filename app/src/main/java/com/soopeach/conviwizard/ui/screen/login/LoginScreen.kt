package com.soopeach.conviwizard.ui.screen.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.soopeach.conviwizard.ui.components.BasicInputTextForm
import com.soopeach.conviwizard.ui.components.Divider
import com.soopeach.conviwizard.ui.screen.Screen

@Composable
fun LoginScreen(
    navController: NavHostController,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        Text(
            text = "안녕하세요. :)\n편의점 마술사입니다.",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.padding(6.dp))
        Divider(
            color = Color.LightGray,
            size = 1
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
            onClick = { /*TODO*/ }) {
            Text(
                text = "로그인 하기",
                style = TextStyle.Default.copy(
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }

        Spacer(modifier = Modifier.padding(10.dp))

        Row {
            Text(
                text = "Don't you have an account?",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.padding(6.dp))

            Text(
                modifier = Modifier.clickable {
                    navController.navigate(Screen.SignUp.route)
                },
                text = "Sign Up",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )
        }

    }

}