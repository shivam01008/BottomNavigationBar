package com.example.urheath.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.urheath.Bottom.BottomNav
import com.example.urheath.R



@Preview(showBackground = true)
@Composable
fun PreviewCard() {
    val navController = rememberNavController()
   // BottomNav()
    ChatCard(profileImageUrl = "", firstName = "Shivam", lastMessage ="Hi How Are You?" , messageTime = "12:21", messageCount = "23")
    //Card(name = "Shivam", dateTime = "15/09/2024", message = "Hello", messageCount ="5" )
}



@Composable
fun ChatCard(
    profileImageUrl: String,
    firstName: String,
    lastMessage: String,
    messageTime: String,
    messageCount: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 17.dp, vertical = 6.dp),
        shape = RoundedCornerShape(16.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(16.dp))
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = firstName,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = lastMessage,
                    color = Color.Gray

                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Column(
                horizontalAlignment = Alignment.End
            ) {
                // Message Time
                Text(
                    text = messageTime,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(8.dp))

                if (messageCount > "12") {
                    Box(
                        modifier = Modifier
                            .padding(0.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = messageCount.toString(),
                            color = Color.White,
                        )
                    }
                }
            }
        }
    }
}