package com.example.utsprojek.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BookingScreen() {
    var fullName by remember { mutableStateOf("") }
    var destination by remember { mutableStateOf("Mount Rinjani Trekking") }
    var date by remember { mutableStateOf("2026-12-01") }
    var pax by remember { mutableStateOf("2") }
    var notes by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {
        Text(text = "Nature Tour Reservation Form", fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Book your guided adventure with secure OTA confirmation", fontSize = 13.sp, color = Color.Gray)

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = fullName,
            onValueChange = { fullName = it },
            label = { Text("Full Name") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = destination,
            onValueChange = { destination = it },
            label = { Text("Selected Destination") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = date,
            onValueChange = { date = it },
            label = { Text("Trip Date (YYYY-MM-DD)") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = pax,
            onValueChange = { pax = it },
            label = { Text("Number of Participants (Pax)") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = notes,
            onValueChange = { notes = it },
            label = { Text("Special Requests / Dietary Notes") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            minLines = 3
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                if (fullName.isNotBlank()) {
                    showDialog = true
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Confirm & Submit Reservation", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Reservation Successful! 🎉") },
                text = {
                    Text("Thank you, $fullName!\nYour booking for $destination on $date ($pax participants) has been successfully registered in our OTA system.")
                },
                confirmButton = {
                    Button(onClick = {
                        showDialog = false
                        fullName = ""
                        notes = ""
                    }) {
                        Text("OK")
                    }
                }
            )
        }
    }
}
