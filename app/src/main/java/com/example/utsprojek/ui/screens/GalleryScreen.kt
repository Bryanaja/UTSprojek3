package com.example.utsprojek.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.utsprojek.data.NatureDataSource

@Composable
fun GalleryScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Nature Static Gallery", fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Captured moments of wild adventures across Indonesia", fontSize = 13.sp, color = androidx.compose.ui.graphics.Color.Gray)

        Spacer(modifier = Modifier.height(16.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(NatureDataSource.galleryItems) { item ->
                Card(
                    shape = RoundedCornerShape(12.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column {
                        // Actual photo for each gallery item
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(110.dp)
                        ) {
                            Image(
                                painter = painterResource(id = item.imageResId),
                                contentDescription = item.title,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )
                        }

                        Column(modifier = Modifier.padding(12.dp)) {
                            Text(text = item.title, fontWeight = FontWeight.Bold, fontSize = 14.sp, maxLines = 1)
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(text = "📍 ${item.location}", fontSize = 11.sp, color = androidx.compose.ui.graphics.Color.Gray)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(text = item.description, fontSize = 11.sp, maxLines = 2, color = androidx.compose.ui.graphics.Color.DarkGray)
                        }
                    }
                }
            }
        }
    }
}
