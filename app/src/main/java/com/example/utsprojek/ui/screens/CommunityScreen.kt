package com.example.utsprojek.ui.screens

import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.utsprojek.data.NatureDataSource

@Composable
fun CommunityScreen() {
    var selectedTab by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Local Communities & Info", fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Empowering local eco-tourism rangers & OTA guidelines", fontSize = 13.sp, color = Color.Gray)

        Spacer(modifier = Modifier.height(16.dp))

        TabRow(selectedTabIndex = selectedTab) {
            Tab(
                selected = selectedTab == 0,
                onClick = { selectedTab = 0 },
                text = { Text("Local Communities") }
            )
            Tab(
                selected = selectedTab == 1,
                onClick = { selectedTab = 1 },
                text = { Text("OTA Guide (WebView)") }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        when (selectedTab) {
            0 -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(NatureDataSource.communities) { comm ->
                        Card(
                            shape = RoundedCornerShape(12.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(text = comm.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                                    Text(text = comm.membersCount, fontSize = 12.sp, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.SemiBold)
                                }
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(text = comm.role, fontSize = 13.sp, color = Color.Gray)
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(text = comm.description, fontSize = 13.sp)
                            }
                        }
                    }
                }
            }
            1 -> {
                // WebView Component requirement with proper settings & internet permissions
                Card(
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    AndroidView(
                        factory = { context ->
                            WebView(context).apply {
                                layoutParams = ViewGroup.LayoutParams(
                                    ViewGroup.LayoutParams.MATCH_PARENT,
                                    ViewGroup.LayoutParams.MATCH_PARENT
                                )
                                settings.javaScriptEnabled = true
                                settings.domStorageEnabled = true
                                settings.cacheMode = WebSettings.LOAD_DEFAULT
                                webViewClient = WebViewClient()
                                loadUrl("https://en.wikipedia.org/wiki/Ecotourism")
                            }
                        },
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}
