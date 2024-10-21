package com.example.urheath.Home

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun AppointmentScreen(navController: NavHostController) {
    var selectedTabIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { }) {
            }
            IconButton(onClick = {  }) {
                Icon(Icons.Filled.Notifications, contentDescription = "Notifications")
            }
        }

        TabLayout(navController, selectedTabIndex) { index ->
            selectedTabIndex = index
        }

        /*when (selectedTabIndex) {
            0 -> UpcomingScreensPreview()
            1 -> CompletedScreen()
        }*/
    }
}

@Composable
fun TabLayout(navController: NavHostController, selectedTabIndex: Int, onTabSelected: (Int) -> Unit) {
    TabRow(selectedTabIndex = selectedTabIndex, modifier = Modifier.fillMaxWidth()) {
        Tab(
            selected = selectedTabIndex == 0,
            onClick = {
                onTabSelected(0)
                navController.navigate("upcoming")
            }
        ) {
            Text(text = "Upcoming")
        }
        Tab(
            selected = selectedTabIndex == 1,
            onClick = {
                onTabSelected(1)
                navController.navigate("completed")
            }
        ) {
            Text(text = "Completed")
        }
    }
}

@Composable
fun CompletedScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Completed Appointments", style = MaterialTheme.typography.titleLarge)
    }
}
