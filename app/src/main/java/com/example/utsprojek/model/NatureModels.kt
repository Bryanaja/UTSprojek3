package com.example.utsprojek.model

import androidx.compose.ui.graphics.Color

data class NatureDestination(
    val id: Int,
    val title: String,
    val location: String,
    val rating: Double,
    val price: String,
    val category: String,
    val description: String,
    val imageResId: Int,
    val gradientColors: List<Color>
)

data class GalleryItem(
    val id: Int,
    val title: String,
    val category: String,
    val location: String,
    val description: String,
    val imageResId: Int,
    val gradientColors: List<Color>
)

data class CommunityItem(
    val id: Int,
    val name: String,
    val role: String,
    val description: String,
    val membersCount: String
)

data class BookingRequest(
    val fullName: String,
    val destination: String,
    val date: String,
    val pax: Int,
    val notes: String
)
