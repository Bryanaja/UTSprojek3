package com.example.utsprojek

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.utsprojek.model.NatureDestination
import com.example.utsprojek.ui.components.BottomNavBar
import com.example.utsprojek.ui.components.Screen
import com.example.utsprojek.ui.screens.*
import com.example.utsprojek.ui.theme.UTSprojekTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UTSprojekTheme {
                EcoNatureApp()
            }
        }
    }
}

@Composable
fun EcoNatureApp() {
    var currentRoute by remember { mutableStateOf(Screen.Home.route) }
    var selectedDestination by remember { mutableStateOf<NatureDestination?>(null) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavBar(
                currentRoute = currentRoute,
                onItemSelected = { screen ->
                    selectedDestination = null
                    currentRoute = screen.route
                }
            )
        }
    ) { innerPadding ->
        androidx.compose.foundation.layout.Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            if (selectedDestination != null) {
                DestinationDetailScreen(
                    destination = selectedDestination!!,
                    onBack = { selectedDestination = null },
                    onBookNow = {
                        selectedDestination = null
                        currentRoute = Screen.Booking.route
                    }
                )
            } else {
                when (currentRoute) {
                    Screen.Home.route -> HomeScreen(
                        onNavigateToDestinations = { currentRoute = Screen.Destinations.route },
                        onSelectDestination = { dest -> selectedDestination = dest }
                    )
                    Screen.Destinations.route -> DestinationsScreen(
                        onSelectDestination = { dest -> selectedDestination = dest }
                    )
                    Screen.Gallery.route -> GalleryScreen()
                    Screen.Community.route -> CommunityScreen()
                    Screen.Booking.route -> BookingScreen()
                }
            }
        }
    }
}
