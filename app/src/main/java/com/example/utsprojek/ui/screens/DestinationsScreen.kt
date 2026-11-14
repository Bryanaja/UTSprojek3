package com.example.utsprojek.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
fun DestinationsScreen(onSelectDestination: (NatureDestination) -> Unit) {
    var searchQuery by remember { mutableStateOf("") }
    val filteredDestinations = NatureDataSource.destinations.filter {
        it.title.contains(searchQuery, ignoreCase = true) ||
                it.location.contains(searchQuery, ignoreCase = true) ||
                it.category.contains(searchQuery, ignoreCase = true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Nature Destinations & Services", fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Explore curated hiking trails, waterfalls, and eco-tours", fontSize = 13.sp, color = androidx.compose.ui.graphics.Color.Gray)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("Search by destination, location, category...") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(filteredDestinations) { dest ->
                Card(
                    shape = RoundedCornerShape(12.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column {
                        // Actual photo banner for each destination
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
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(text = dest.title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                                Surface(
                                    shape = RoundedCornerShape(8.dp),
                                    color = MaterialTheme.colorScheme.tertiaryContainer
                                ) {
                                    Text(
                                        text = dest.category,
                                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        color = MaterialTheme.colorScheme.onTertiaryContainer
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(4.dp))
                            Text(text = "📍 ${dest.location}", fontSize = 13.sp, color = androidx.compose.ui.graphics.Color.Gray)
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(text = dest.description, fontSize = 13.sp, maxLines = 3)
                            Spacer(modifier = Modifier.height(12.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column {
                                    Text(text = "Starting from", fontSize = 11.sp, color = androidx.compose.ui.graphics.Color.Gray)
                                    Text(text = dest.price, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                                }
                                Button(onClick = { onSelectDestination(dest) }) {
                                    Text("Book Tour")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
