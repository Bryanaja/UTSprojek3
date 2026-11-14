package com.example.utsprojek.ui.components

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

sealed class Screen(val route: String, val title: String, val emoji: String) {
    object Home : Screen("home", "Dashboard", "🏠")
    object Destinations : Screen("destinations", "Destinasi", "⛰️")
    object Gallery : Screen("gallery", "Galeri", "📸")
    object Community : Screen("community", "Komunitas", "👥")
    object Booking : Screen("booking", "Reservasi", "📅")
}

@Composable
fun BottomNavBar(currentRoute: String, onItemSelected: (Screen) -> Unit) {
    val items = listOf(
        Screen.Home,
        Screen.Destinations,
        Screen.Gallery,
        Screen.Community,
        Screen.Booking
    )

    NavigationBar {
        items.forEach { screen ->
            NavigationBarItem(
                icon = { Text(screen.emoji, fontSize = 20.sp) },
                label = { Text(screen.title) },
                selected = currentRoute == screen.route,
                onClick = { onItemSelected(screen) }
            )
        }
    }
}
