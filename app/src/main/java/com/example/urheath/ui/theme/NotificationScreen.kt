package com.example.urheath.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.urheath.R


@Preview
@Composable
fun NotificationScreen() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val (topBar) = createRefs()

        // Row containing the back button and centered title
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(topBar) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Back button icon on the left
            Icon(
                painter = painterResource(id = R.drawable.ivback),
                contentDescription = "Back Button",
                tint = Color.Unspecified
            )

            // Spacer to push the title to the center
            Spacer(modifier = Modifier.weight(1f))

            // Centered title
            Text(
                text = "Notifications",
                textAlign = TextAlign.Center
            )

            // Empty Spacer to balance the row
            Spacer(modifier = Modifier.weight(1f))
        }


    }
}

@Preview
@Composable
fun NotiItem() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val (ivProfile, tvFirst, textName, ivImage, divider) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.noti),
            contentDescription = "Notification Icon",
            modifier = Modifier
                .padding(top = 16.dp)
                .constrainAs(ivProfile) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                }
        )
        Text(
            text = "Upcoming Event",
            color = Color(0xFF333333),
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 12.dp)
                .constrainAs(tvFirst){
                    start.linkTo(ivProfile.end)
                    top.linkTo(ivProfile.top)
                }
        )

        Text(
            text = "MedCure is organizing an event for all medicine practitioners",
            fontSize = 12.sp,
            maxLines = 2,  
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier

                .padding(start = 12.dp, top = 4.dp)
                .constrainAs(textName){
                    start.linkTo(ivProfile.end)
                    top.linkTo(tvFirst.bottom)
                    end.linkTo(parent.end)
                }
        )
        Text(
            text = "1 min ago",
            fontSize = 12.sp,
            modifier = Modifier
                .padding(horizontal = 9.dp)
                .constrainAs(ivImage) {
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                }
        )
    }
}