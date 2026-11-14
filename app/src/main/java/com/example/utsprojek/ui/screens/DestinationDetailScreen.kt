package com.example.utsprojek.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.utsprojek.model.NatureDestination

@Composable
fun DestinationDetailScreen(destination: NatureDestination, onBack: () -> Unit, onBookNow: () -> Unit) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {
        // Actual High-Quality Photo Banner for the Destination
        Card(
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(id = destination.imageResId),
                    contentDescription = destination.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = destination.title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFFFFA000).copy(alpha = 0.2f)
            ) {
                Text(
                    text = "⭐ ${destination.rating}",
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFE65100)
                )
            }
        }

        Spacer(modifier = Modifier.height(6.dp))
        Text(text = "📍 ${destination.location}", fontSize = 14.sp, color = Color.Gray)

        Spacer(modifier = Modifier.height(12.dp))
        Surface(
            shape = RoundedCornerShape(8.dp),
            color = MaterialTheme.colorScheme.secondaryContainer
        ) {
            Text(
                text = "Category: ${destination.category} Adventure",
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "About Destination", fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Spacer(modifier = Modifier.height(6.dp))
        Text(text = destination.description, fontSize = 14.sp, lineHeight = 20.sp, color = Color.DarkGray)

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = "Price per person", fontSize = 12.sp, color = Color.Gray)
                Text(text = destination.price, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
            }
            Button(onClick = onBookNow) {
                Text("Book This Tour")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedButton(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back to Dashboard")
        }
    }
}
