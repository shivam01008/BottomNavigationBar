package com.example.urheath

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bttomnavigationbar.BottomNav
import com.example.bttomnavigationbar.SootheBottomNavigation
//import com.example.urheath.Bottom.BottomNav
//import com.example.urheath.Bottom.DetailsScreen
//import com.example.urheath.Bottom.HomeScreen1
//import com.example.urheath.Bottom.ProfileScreen1
//import com.example.urheath.Bottom.SootheBottomNavigation
import com.example.urheath.Home.AppointmentScreen
import com.example.urheath.Home.CompletedScreen
import com.example.urheath.Home.TabLayout
import com.example.urheath.Home.UpcomingScreensPreview
import com.example.urheath.Intro.IntroductionScreen
import com.example.urheath.viewmodel.AuthViewModel
import com.example.urheath.viewmodel.NetworkResponse
import com.google.firebase.annotations.concurrent.Background
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomNav()
//            val navController = rememberNavController()
//            MainScreen(navController)

        }
    }
}
@Preview
@Composable
fun SignInEmailScreen(
    navController: NavHostController,
    authViewModel: AuthViewModel = hiltViewModel(),
    isProgress: (Boolean) -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var token by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    val loginResponse by authViewModel.loginResponse.collectAsState()

    loginResponse?.let { response ->
        when (response) {
            is NetworkResponse.Loading -> {
                isProgress(true)
            }

            is NetworkResponse.Success -> {
                isProgress(false)
                navController.navigate("appointments")
            }

            is NetworkResponse.Failure -> {
                isProgress(false)
            }

            else -> {
                isProgress(false)
            }
        }
    }


    Scaffold(

    ) {
        Log.e("demo", "$it")
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Top Image",
            )

            Text(
                text = "Login to Your Account",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(top = 32.dp)
            )

            Text(
                text = "We’ll use your email to find your account if you\n have one",
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 16.dp),
                lineHeight = 20.sp
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text(text = "Enter email address") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "Enter password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                singleLine = true,
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {

                    }
                },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
            )

            TextButton(onClick = { navController.navigate("resetPasswordScreen") })
            {
                Text(
                    text = "Reset Password?",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 14.dp)
                )
            }

            Button(
                onClick = { authViewModel.login(email, password, token) }, // Call login method
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp)
            ) {
                Text(text = "Sign In", fontSize = 17.sp, fontWeight = FontWeight.Bold)
            }

            Button(
                onClick = { navController.navigate("home") },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp)
            ) {
                Text(
                    text = "Login Using OTP",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
        }
    }
}


val onboardPages = listOf(
    OnboardingPage(
        background = Color.Gray,
        title = "Personalize Your Mental Health State With AI",
        stepNumber = 1,
        image = R.drawable.splash
    ),
    OnboardingPage(
        background = Color.Black,
        title = "Intelligent Mood Tracking & Emotion Insights",
        stepNumber = 2,
        image = R.drawable.splash
    ),
    OnboardingPage(
        background = Color.Black,
        title = "Mindful Resources That Makes You Happy",
        stepNumber = 3,
        image = R.drawable.splash
    ),
    OnboardingPage(
        background = Color.Black,
        title = "Loving & Supportive Community",
        stepNumber = 4,
        image = R.drawable.splash
    )
)

data class OnboardingPage(
    val background: Color,
    val title: String,
    val stepNumber: Int,
    @DrawableRes val image: Int
)

@Composable
fun MainScreen(navController: NavHostController) {
    var isProgress: Boolean by remember {
        mutableStateOf(false)
    }
    NavHost(
        navController = navController,
        startDestination = "introduction"
    ) {
        composable("introduction") {
            IntroductionScreen(navController)
        }
        composable("signup") {
            SignInEmailScreen(navController) {
                isProgress = it
            }
        }
        composable("appointments") {
            AppointmentScreen(navController)
        }
        composable("tabLayout") {
            TabLayout(navController)
        }
        composable("upcoming") {
            UpcomingScreensPreview()

        }
        composable("completed") {
            CompletedScreen()
        }
        composable("resetPasswordScreen") {
            ResetPasswordScreen(navController)
        }
//        composable("home") {
//            HomeScreen1(navController)
//        }
//        composable("profile") {
//            ProfileScreen1(navController)
//        }
//        // New screen without bottom navigation
//        composable("details") {
//            DetailsScreen(navController) // Pass navController to DetailsScreen
//        }

    }

    ProgressBar(isProgress)
}

@Composable
fun ProgressBar(isProgress: Boolean) {
    if (isProgress) LinearProgressIndicator() else return
}

@Composable
fun TabLayout(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "introduction"
    ) {
        composable("tabLayout") {
            TabLayout(navController)
        }
        composable("upcoming") {
            UpcomingScreensPreview()

        }
        composable("completed") {
            CompletedScreen()
        }

    }
}


@Composable
fun <T> MutableLiveData<T>.observeAsState(initial: T? = null): T? {
    var state by remember { mutableStateOf(initial) }

    DisposableEffect(this) {
        val observer = { value: T? -> state = value }

        observeForever(observer)

        onDispose {
            removeObserver(observer)
        }
    }

    return state
}


@Composable
fun ResetPasswordScreen(navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var isProgress by remember { mutableStateOf(false) }

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp)
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Top Image",
            )

            Text(
                text = "Reset Your Password",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(top = 32.dp)
            )

            Text(
                text = "Please enter your email to receive a password reset link.",
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 16.dp),
                lineHeight = 20.sp
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text(text = "Enter email address") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
            )

            Button(
                onClick = {
                    // Handle reset password logic here
                    isProgress = true
                    // Simulate password reset process
                    // You can call your ViewModel function to initiate password reset
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp)
            ) {
                Text(text = "Submit", fontSize = 17.sp, fontWeight = FontWeight.Bold)
            }

            if (isProgress) {
                CircularProgressIndicator(modifier = Modifier.padding(top = 16.dp))
            }
        }
    }
}
