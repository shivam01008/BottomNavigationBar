package com.example.urheath.Home

import android.os.Message
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.urheath.R


@Composable
fun UpcomingScreen(users: List<User>) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(users) { user ->
            UserCard(
                name = user.name,
                age = user.age,
                gender = user.gender,
                role = user.role,
                reasonForCall = user.reasonForCall,
                dateTime = user.dateTime,
                callTime = user.callTime
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun UpcomingScreensPreview() {
    val sampleUsers = listOf(
        User("John Smith", "31 Years", "Male", "Self", "Checkup", "28 Nov 2023 06:30 PM", "Nov"),
        User("John Smith", "31 Years", "Male", "Self", "Checkup", "28 Nov 2023 06:30 PM", "Nov"),
        User("John Smith", "31 Years", "Male", "Self", "Checkup", "28 Nov 2023 06:30 PM", "Nov"),
        User("John Smith", "31 Years", "Male", "Self", "Checkup", "28 Nov 2023 06:30 PM", "Nov"),
        User("John Smith", "31 Years", "Male", "Self", "Checkup", "28 Nov 2023 06:30 PM", "Nov"),
        User("John Smith", "31 Years", "Male", "Self", "Checkup", "28 Nov 2023 06:30 PM", "Nov"),
        User("John Smith", "31 Years", "Male", "Self", "Checkup", "28 Nov 2023 06:30 PM", "Nov"),
        User("John Smith", "31 Years", "Male", "Self", "Checkup", "28 Nov 2023 06:30 PM", "Nov"),
        User("John Smith", "31 Years", "Male", "Self", "Checkup", "28 Nov 2023 06:30 PM", "Nov"),
        User("John Smith", "31 Years", "Male", "Self", "Checkup", "28 Nov 2023 06:30 PM", "Nov"),
        User("John Smith", "31 Years", "Male", "Self", "Checkup", "28 Nov 2023 06:30 PM", "Nov"),
        User("John Smith", "31 Years", "Male", "Self", "Checkup", "28 Nov 2023 06:30 PM", "Nov"),
        User("John Smith", "31 Years", "Male", "Self", "Checkup", "28 Nov 2023 06:30 PM", "Nov"),
        User("Jane Doe", "28 Years", "Female", "Self", "Consultation", "29 Nov 2023 09:00 AM", "Nov")
    )
    UpcomingScreen(users = sampleUsers)

}

data class User(
    val name: String,
    val age: String,
    val gender: String,
    val role: String,
    val reasonForCall: String,
    val dateTime: String,
    val callTime: String
)

@Composable
fun UserCard(
    name: String = "John Smith",
    any: String = "31 Years",
    gender: String = "Male",
    role: String = "Self",
    age: String = "",
    reasonForCall: String = "Reason For Call",
    dateTime: String = " 28 Nov 2023 06:30 pm",
    callTime: String = " Nov"
){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 5.dp, vertical = 5.dp),
        shape = RoundedCornerShape(24.dp)
    ) {
        Column(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()) {
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Column (modifier = Modifier.weight(1f)){
                    Text(text = name,
                        style = TextStyle(color = Color.Black, fontSize = 20.sp,fontWeight = FontWeight.Black)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = age,
                            style = TextStyle(color = Color.DarkGray, fontSize = 14.sp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = gender,
                            style = TextStyle(color = Color.DarkGray, fontSize = 14.sp),
                            modifier = Modifier.padding(start = 10.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = role,
                            style = TextStyle(color = Color.DarkGray, fontSize = 14.sp),
                            modifier = Modifier.padding(start = 10.dp)
                        )
                    }
                }
                Button(
                    onClick = {  },
                    modifier = Modifier
                        .size(width = 109.dp, height = 30.dp)
                        .padding(start = 8.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Start Call",
                        modifier = Modifier.size(18.dp),
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Start Call",
                        color = Color.White,
                        fontSize = 14.sp
                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row {
                Text(
                    text = "Virtual",
                    style = TextStyle(color = Color.DarkGray, fontSize = 14.sp),
                    modifier = Modifier.padding(start = 6.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Primary Care",
                    style = TextStyle(color = Color.DarkGray, fontSize = 14.sp),
                    modifier = Modifier.padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = reasonForCall,
                    style = TextStyle(
                        color = Color(0xFF6495ED),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = dateTime,
                    style = TextStyle(color = Color.DarkGray, fontSize = 14.sp),
                    modifier = Modifier.padding(start = 8.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = callTime,
                    style = TextStyle(
                        color = Color(0xFF05825D),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}





