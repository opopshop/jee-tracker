package com.jeetracker.app.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun AddTestScreen(navController: NavHostController) {
    val testName = remember { mutableStateOf("") }
    val date = remember { mutableStateOf("") }
    val total = remember { mutableStateOf(100) }
    val scored = remember { mutableStateOf(0) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Manual Test Input", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(value = testName.value, onValueChange = { testName.value = it }, label = { Text("Test Name") })
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = date.value, onValueChange = { date.value = it }, label = { Text("Date (dd-mm-yyyy)") })
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = total.value.toString(), onValueChange = { total.value = it.toIntOrNull() ?: 100 }, label = { Text("Total Marks") })
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = scored.value.toString(), onValueChange = { scored.value = it.toIntOrNull() ?: 0 }, label = { Text("Scored Marks") })
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = { /* save test */ navController.popBackStack() }, modifier = Modifier.fillMaxWidth()) { Text("Save & Analyze") }
    }
}
