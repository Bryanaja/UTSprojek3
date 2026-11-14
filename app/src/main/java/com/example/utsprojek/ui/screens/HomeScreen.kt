package com.example.utsprojek.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.utsprojek.data.NatureDataSource
import com.example.utsprojek.model.NatureDestination

@Composable
fun HomeScreen(onNavigateToDestinations: () -> Unit, onSelectDestination: (NatureDestination) -> Unit) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {
        // App Header / Welcome Card
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = "🌿 EcoNature OTA Indonesia",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Explore breathtaking mountains, pristine waterfalls, lush forests, and serene lakes across the archipelago.",
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = onNavigateToDestinations,
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    Text("Explore Adventures Now")
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Categories Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Adventure Categories", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            TextButton(onClick = onNavigateToDestinations) {
                Text("View All")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Categories Row
        val categories = listOf("Mountain", "Waterfall", "Forest", "Lake")
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            categories.forEach { cat ->
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = MaterialTheme.colorScheme.secondaryContainer,
                    modifier = Modifier.size(width = 110.dp, height = 60.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        val emoji = when(cat) {
                            "Mountain" -> "⛰️"
                            "Waterfall" -> "🌊"
                            "Forest" -> "🌲"
                            else -> "💧"
                        }
                        Text(
                            text = "$emoji $cat",
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onSecondaryContainer
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Featured Destinations (CardView / RecyclerView style)
        Text(text = "Featured Nature Destinations", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(12.dp))

        NatureDataSource.destinations.take(3).forEach { dest ->
            Card(
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
            ) {
                Column {
                    // Actual photo header for featured destinations
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(140.dp)
                    ) {
                        Image(
                            painter = painterResource(id = dest.imageResId),
                            contentDescription = dest.title,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }

                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = dest.title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                            Text(text = "⭐ ${dest.rating}", color = androidx.compose.ui.graphics.Color(0xFFFFA000), fontWeight = FontWeight.Bold)
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = "📍 ${dest.location}", fontSize = 13.sp, color = androidx.compose.ui.graphics.Color.Gray)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = dest.description, fontSize = 13.sp, maxLines = 2)
                        Spacer(modifier = Modifier.height(12.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = dest.price, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                            OutlinedButton(onClick = { onSelectDestination(dest) }) {
                                Text("View Details")
                            }
                        }
                    }
                }
            }
        }
    }
}
