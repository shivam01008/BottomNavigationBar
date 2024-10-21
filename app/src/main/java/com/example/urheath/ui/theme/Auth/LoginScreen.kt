package com.example.urheath.ui.theme.Auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.urheath.R


@Composable
fun LoginScreen() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val (backButton, topImage, titleText, inputFields, loginButton, footerText) = createRefs()


        IconButton(
            onClick = { /* Handle back button click */ },
            modifier = Modifier
                .constrainAs(backButton) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ivback),
                contentDescription = "Back Button",
                tint = Color.Unspecified
            )
        }

        Image(
            painter = painterResource(id = R.drawable.img_2),
            contentDescription = "Top Image",
            modifier = Modifier
                .constrainAs(topImage) {
                    top.linkTo(backButton.bottom, margin = 24.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .width(280.dp)
                .height(200.dp)
                .padding(horizontal = 16.dp)
        )


        Text(
            text = "Login",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            ),
            modifier = Modifier
                .constrainAs(titleText) {
                    top.linkTo(topImage.bottom, margin = 24.dp)
                    start.linkTo(parent.start, margin = 24.dp)
                }
                .padding(vertical = 16.dp)
        )


        Column(
            modifier = Modifier
                .constrainAs(inputFields) {
                    top.linkTo(titleText.bottom, margin = 24.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(horizontal = 16.dp)
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = { /* Handle value change */ },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.emails),
                        contentDescription = "Email Icon"
                    )
                },
                label = { Text("Email") },
                placeholder = { Text("Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, shape = RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = "",
                onValueChange = { /* Handle value change */ },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.emails),
                        contentDescription = "Password Icon"
                    )
                },
                label = { Text("Password") },
                placeholder = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, shape = RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Forgot Password?",
                color = Color(0xFF0D3995),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.End)
            )
        }

        Button(
            onClick = { /* Handle login button click */ },
            modifier = Modifier
                .constrainAs(loginButton) {
                    top.linkTo(inputFields.bottom, margin = 24.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth()
                .background(Color.Black)
        ) {
            Text(
                text = "Login",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }

        Row(
            modifier = Modifier
                .constrainAs(footerText) {
                    bottom.linkTo(parent.bottom, margin = 24.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Already have an account?",
                color = Color(0xFF555555),
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(end = 4.dp)
            )
            Text(
                text = "Login",
                color = Color(0xFF0D3995),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    LoginScreen()
}
