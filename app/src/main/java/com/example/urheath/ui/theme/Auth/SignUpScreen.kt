package com.example.urheath.ui.theme.Auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.urheath.Home.UpcomingScreen
import com.example.urheath.R


@Composable
fun SignUpScreen() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val (backButton, topImage, titleText, inputFields, loginButton, footerText) = createRefs()

        IconButton(
            onClick = {  },
            modifier = Modifier
                .constrainAs(backButton) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
                .padding(16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ivback),
                contentDescription = "Back Button",
                tint = Color.Unspecified
            )
        }

        // Top Image
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Top Image",
            modifier = Modifier
                .constrainAs(topImage) {
                    top.linkTo(backButton.bottom, margin = 24.dp) // Adjusted margin
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .width(280.dp)
                .height(200.dp)
                .padding(horizontal = 16.dp)
        )
        // Title Text
        Text(
            text = "Sign Up",
            style = TextStyle(
                fontSize = 24.sp, // Increased font size for better visibility
                fontWeight = FontWeight.Bold,
                color = Color.Black
            ),
            modifier = Modifier
                .constrainAs(titleText) {
                    top.linkTo(topImage.bottom, margin = 24.dp)
                    start.linkTo(parent.start, margin = 24.dp)
                    // Align text to start and end of the parent with margin
                }
                .padding(vertical = 16.dp) // Added vertical padding
        )

        Column(
            modifier = Modifier
                .constrainAs(inputFields){
                    top.linkTo(titleText.bottom, margin = 24.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ){
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSignScreen() {
    SignUpScreen()
}