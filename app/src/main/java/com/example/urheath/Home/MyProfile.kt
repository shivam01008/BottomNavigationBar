package com.example.urheath.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.urheath.R


@Preview(showBackground = true)
@Composable
fun PreviewMyprofile() {
    ProfileScreen()
}

@Composable
fun ProfileScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 14.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "My Profile",
                style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF000000))
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp)
                .padding(horizontal = 34.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Profile Picture",
                modifier = Modifier.size(96.dp)
            )



            Text(
                text = "Registration ",
                style = TextStyle(fontSize = 14.sp, color = Color(0xFFB0BEC5)),
                modifier = Modifier.padding(top = 5.dp)
            )

            Button(
                onClick = { },
                modifier = Modifier
                    .padding(top = 8.dp)
                    .width(106.dp),
                colors = ButtonDefaults.buttonColors(),
                enabled = false
            ) {
                Text("Edit Profile", color = Color.White)
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 17.dp, vertical = 5.dp)
                .padding(top = 25.dp),
            shape = RoundedCornerShape(24.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Email Address",
                    style = TextStyle(fontSize = 14.sp, color = Color(0xFFB0BEC5))
                )
                Text(
                    text = "user.email",
                    style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF000000))
                )

                Text(
                    text = "Phone Number",
                    style = TextStyle(fontSize = 14.sp, color = Color(0xFFB0BEC5)),
                    modifier = Modifier.padding(top = 18.dp)
                )
                Text(
                    text = "user.phone",
                    style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF000000))
                )

                Text(
                    text = "Date Registered on",
                    style = TextStyle(fontSize = 14.sp, color = Color(0xFFB0BEC5)),
                    modifier = Modifier.padding(top = 18.dp)
                )
                Text(
                    text = "user.dob",
                    style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF000000))
                )

                Text(
                    text = "Specialty",
                    style = TextStyle(fontSize = 14.sp, color = Color(0xFFB0BEC5)),
                    modifier = Modifier.padding(top = 18.dp)
                )
                Text(
                    text = "user.speciality",
                    style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF000000))
                )

                Text(
                    text = "Care Type",
                    style = TextStyle(fontSize = 14.sp, color = Color(0xFFB0BEC5)),
                    modifier = Modifier.padding(top = 18.dp)
                )
                Text(
                    text = "user.care_type",
                    style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF000000))
                )
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 17.dp, vertical = 5.dp)
                .padding(top = 16.dp),
            shape = RoundedCornerShape(24.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "About",
                    style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.White)
                )
                Text(
                    text ="about",
                    style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.White)
                )
            }
        }
    }
}
