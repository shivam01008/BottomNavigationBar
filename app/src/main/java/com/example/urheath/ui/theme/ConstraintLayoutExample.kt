package com.example.urheath.ui.theme

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ConstraintLayoutExample() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize() // Takes up full screen size
    ) {
        val (title, button, footerText) = createRefs()

        // Title text
        Text(
            text = "Hello ConstraintLayout",
            fontSize = 24.sp,
            color = Color.Black,
            modifier = Modifier
                .constrainAs(title) {
                    top.linkTo(parent.top, margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        // Button-like text
        Text(
            text = "Click Me",
            fontSize = 18.sp,
            color = Color.Blue,
            modifier = Modifier
                .constrainAs(button) {
                    top.linkTo(title.bottom, margin = 24.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        // Footer text
        Text(
            text = "Footer Text",
            fontSize = 18.sp,
            color = Color.Black,
            modifier = Modifier
                .constrainAs(footerText) {
                    top.linkTo(button.bottom, margin = 24.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewConstraintLayoutExample() {
    ConstraintLayoutExample()
}
