package com.example.urheath.Intro

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.pager.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun IntroductionScreen(navController: NavController) {
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()

    Scaffold(
        bottomBar = {
            BottomBar(pagerState, scope, navController)
        }
    ) { padding ->
        Log.e("padding", "$padding")
        HorizontalPager(
            state = pagerState,
            count = 3,
            modifier = Modifier
        ) { page ->
            when (page) {
                0 -> OnboardingPage()
                1 -> SecondPage()
                2 -> ThirdPage()
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BottomBar(pagerState: PagerState, scope: CoroutineScope, navController: NavController) {
    val buttonText = when (pagerState.currentPage) {
        0 -> "Next"
        1 -> "Next"
        else -> "Get Started"
    }

    Button(
        onClick = {
            if (pagerState.currentPage < 2) {
                scope.launch {
                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                }
            } else {
                navController.navigate("signUp") // Navigate to SignUp
            }
        },
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(text = buttonText)
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PagerIndicator(pagerState: PagerState) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        repeat(3) { index ->
            val color = if (pagerState.currentPage == index) Color.Blue else Color.Gray
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .size(8.dp)
                    .background(color, shape = CircleShape)
            )
        }
    }
}

