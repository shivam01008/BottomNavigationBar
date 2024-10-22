package com.example.bttomnavigationbar

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

data class NavigationItem(val label: String, val icon: @Composable () -> Unit, val route: String)

@Composable
fun SootheBottomNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    items: List<NavigationItem>
) {
    require(items.size <= 5) { "You can only have up to 5 navigation items" }

    var selectedItem by remember { mutableStateOf(0) }

    NavigationBar(modifier = modifier) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { item.icon() },
                label = { Text(text = item.label) },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    navController.navigate(item.route)
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen1(navController: NavHostController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text(text = "Home") })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Home Screen",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .clickable(onClick = { navController.navigate("details") })
                    .padding(16.dp)
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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomNav() {
    val navController = rememberNavController()

    val items = listOf(
        NavigationItem(
            label = stringResource(R.string.bottom_navigation_home),
            icon = { Icon(imageVector = Icons.Default.Spa, contentDescription = null) },
            route = "home"
        ),
        NavigationItem(
            label = stringResource(R.string.bottom_navigation_profile),
            icon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null) },
            route = "profile"
        )
        // Add more items if needed, limit up to 5
    )

    Scaffold(
        bottomBar = {
            val currentDestination = navController.currentBackStackEntryAsState().value?.destination?.route
            if (currentDestination in listOf("home", "profile")) {
                SootheBottomNavigation(navController = navController, items = items)
            }
        }
    ) {
        NavHost(navController = navController, startDestination = "home") {
            composable("home") { HomeScreen1(navController) }
            composable("profile") { ProfileScreen1(navController) }
            composable("details") { DetailsScreen(navController) }
        }
    }
}
