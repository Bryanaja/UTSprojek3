package com.example.utsprojek.data

import androidx.compose.ui.graphics.Color
import com.example.utsprojek.R
import com.example.utsprojek.model.CommunityItem
import com.example.utsprojek.model.GalleryItem
import com.example.utsprojek.model.NatureDestination

object NatureDataSource {
    val destinations = listOf(
        NatureDestination(
            id = 1,
            title = "Mount Rinjani Trekking",
            location = "Lombok, Nusa Tenggara Barat",
            rating = 4.9,
            price = "Rp 1.500.000",
            category = "Mountain",
            description = "Experience the majestic active volcano with stunning crater lake Segara Anak. Perfect for adventure seekers and nature lovers.",
            imageResId = R.drawable.rinjani,
            gradientColors = listOf(Color(0xFF1B5E20), Color(0xFF4CAF50), Color(0xFF81C784))
        ),
        NatureDestination(
            id = 2,
            title = "Tumpak Sewu Waterfall",
            location = "Lumajang, Jawa Timur",
            rating = 4.8,
            price = "Rp 350.000",
            category = "Waterfall",
            description = "Known as the Niagara of Indonesia, a magnificent tiered waterfall surrounded by lush tropical rainforest walls.",
            imageResId = R.drawable.tumpaksewu,
            gradientColors = listOf(Color(0xFF006064), Color(0xFF00ACC1), Color(0xFF4DD0E1))
        ),
        NatureDestination(
            id = 3,
            title = "Ubud Monkey Forest & Rice Terraces",
            location = "Bali",
            rating = 4.7,
            price = "Rp 250.000",
            category = "Forest",
            description = "Stunning emerald green Tegallalang rice terraces combined with sacred sanctuary forests full of natural wonder.",
            imageResId = R.drawable.ubud,
            gradientColors = listOf(Color(0xFF2E7D32), Color(0xFF66BB6A), Color(0xFFA5D6A7))
        ),
        NatureDestination(
            id = 4,
            title = "Lake Toba & Samosir Island",
            location = "Sumatera Utara",
            rating = 4.9,
            price = "Rp 950.000",
            category = "Lake",
            description = "The largest volcanic lake in the world offering breathtaking water horizons, cool mountain breeze, and rich local Batak heritage.",
            imageResId = R.drawable.laketoba,
            gradientColors = listOf(Color(0xFF0D47A1), Color(0xFF1976D2), Color(0xFF64B5F6))
        ),
        NatureDestination(
            id = 5,
            title = "Bromo Tengger Semeru",
            location = "Probolinggo, Jawa Timur",
            rating = 4.9,
            price = "Rp 600.000",
            category = "Mountain",
            description = "Witness otherworldly sunrise views over the active Mt. Bromo crater and whispering sand sea desert.",
            imageResId = R.drawable.bromo,
            gradientColors = listOf(Color(0xFFE65100), Color(0xFFF57C00), Color(0xFFFFB74D))
        )
    )

    val galleryItems = listOf(
        GalleryItem(1, "Sunrise at Mt. Bromo Peak", "Mountain", "East Java", "Golden hour light illuminating volcanic smoke and sand sea.", R.drawable.bromo, listOf(Color(0xFFE65100), Color(0xFFFFA726))),
        GalleryItem(2, "Segara Anak Crater Lake", "Lake", "Lombok", "Crystal clear blue volcanic lake nestled inside Rinjani caldera.", R.drawable.rinjani, listOf(Color(0xFF0D47A1), Color(0xFF42A5F5))),
        GalleryItem(3, "Madakaripura Hidden Waterfall", "Waterfall", "East Java", "Majestic curtain waterfall hidden inside a deep mossy canyon.", R.drawable.tumpaksewu, listOf(Color(0xFF006064), Color(0xFF26A69A))),
        GalleryItem(4, "Borobudur Dawn Mist", "Culture & Nature", "Central Java", "Ancient stone stupas surrounded by misty tropical rainforest and hills.", R.drawable.ubud, listOf(Color(0xFF3E2723), Color(0xFF8D6E63))),
        GalleryItem(5, "Lake Toba Horizon", "Marine Nature", "Sumatera Utara", "Pristine waters and majestic caldera landscape of Toba.", R.drawable.laketoba, listOf(Color(0xFF004D40), Color(0xFF00897B)))
    )

    val communities = listOf(
        CommunityItem(1, "Rinjani Eco-Guiders", "Local Ranger Association", "Dedicated conservationists and licensed mountain guides protecting mountain trails.", "120 Members"),
        CommunityItem(2, "Tumpak Sewu Forest Guardians", "Eco-Tourism Community", "Local villagers managing safe canyon treks and river conservation programs.", "85 Members"),
        CommunityItem(3, "Bromo Tengger Horsemen Alliance", "Cultural & Nature Community", "Traditional Tenggerese horse handlers and homestay hosts providing authentic highland hospitality.", "240 Members")
    )
}
