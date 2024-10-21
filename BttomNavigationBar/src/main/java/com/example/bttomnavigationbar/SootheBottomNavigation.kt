package com.example.bttomnavigationbar

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bttomnavigationbar.R

@Composable
fun SootheBottomNavigation(navController: NavHostController, modifier: Modifier = Modifier) {
    var selectedItem by remember { mutableStateOf(0) }

    NavigationBar(modifier = modifier) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Spa,
                    contentDescription = null
                )
            },
            label = {
                Text(text = stringResource(R.string.bottom_navigation_home))
            },
            selected = selectedItem == 0,
            onClick = {
                selectedItem = 0
                navController.navigate("home") // Navigate to home screen
            }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
            label = {
                Text(text = stringResource(R.string.bottom_navigation_profile))
            },
            selected = selectedItem == 1,
            onClick = {
                selectedItem = 1
                navController.navigate("profile")
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen1(navController: NavHostController) {
    Scaffold(
        topBar = {
            // You can add a TopAppBar here if needed
            CenterAlignedTopAppBar(
                title = { Text(text = "Home") }
            )
        }
    ) { innerPadding ->
        // Content of the screen
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding) // Use innerPadding to avoid overlapping with top bar
                .padding(16.dp), // Additional padding
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Home Screen",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .clickable(onClick = {
                        navController.navigate("details") // Navigate to DetailsScreen
                    })
                    .padding(16.dp) // Add padding to clickable text
            )
        }
    }
}

@Composable
fun ProfileScreen1(navController: NavHostController) {
    Text(text = "Profile Screen")
}



@Composable
fun DetailsScreen(navController: NavHostController) {
    Column {
        Text(text = "Details Screen")
        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Go Back")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBottomNav() {
    val navController = rememberNavController()
    BottomNav()

}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomNav() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            // Only show the bottom navigation on certain screens
            val currentDestination = navController.currentBackStackEntryAsState().value?.destination?.route
            if (currentDestination in listOf("home", "profile")) {
                SootheBottomNavigation(navController = navController)
            }
        }
    ) {
        // Navigation host to handle composable destinations
        NavHost(
            navController = navController,
            startDestination = "home"
        ) {
            composable("home") {
                HomeScreen1(navController)
            }
            composable("profile") {
                ProfileScreen1(navController)
            }
            // New screen without bottom navigation
            composable("details") {
                DetailsScreen(navController) // Pass navController to DetailsScreen
            }
        }
    }
}






