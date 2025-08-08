package com.jeetracker.app.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun LogStudyScreen(navController: NavHostController) {
    val subject = remember { mutableStateOf("Maths") }
    val topic = remember { mutableStateOf("") }
    val minutes = remember { mutableStateOf(25) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Log Study", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = subject.value, onValueChange = { subject.value = it }, label = { Text("Subject") })
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = topic.value, onValueChange = { topic.value = it }, label = { Text("Topic") })
        Spacer(modifier = Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { minutes.value = 25 }) { Text("25") }
            Button(onClick = { minutes.value = 50 }) { Text("50") }
            Button(onClick = { minutes.value = 90 }) { Text("90") }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /* persist session */ navController.popBackStack() }, modifier = Modifier.fillMaxWidth()) { Text("Save") }
    }
}
