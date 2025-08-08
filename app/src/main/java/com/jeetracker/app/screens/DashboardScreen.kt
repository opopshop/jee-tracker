package com.jeetracker.app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun DashboardScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Text("JEE Tracker", style = MaterialTheme.typography.headlineSmall, modifier = Modifier.weight(1f))
            IconButton(onClick = {}) { Icon(Icons.Default.Settings, contentDescription = "Settings") }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            KPIItem("Today hrs", "3h") { /* noop */ }
            KPIItem("Weekly avg", "4.2h") { /* noop */ }
            KPIItem("% Completion", "42%") { /* noop */ }
        }
        Spacer(modifier = Modifier.height(20.dp))
        SubjectBar(Color(0xFFFFD600), "Maths", "35%", Modifier.clickable { /* open */ })
        Spacer(modifier = Modifier.height(8.dp))
        SubjectBar(Color(0xFF2196F3), "Physics", "48%", Modifier.clickable { })
        Spacer(modifier = Modifier.height(8.dp))
        SubjectBar(Color(0xFFF44336), "Chemistry", "29%", Modifier.clickable { })
        Spacer(modifier = Modifier.height(24.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = { navController.navigate("log_study") }) { Text("Log Study") }
            Button(onClick = { navController.navigate("pomodoro") }) { Text("Start Pomodoro") }
            Button(onClick = { navController.navigate("add_test") }) { Text("Add Test") }
        }
    }
}

@Composable
fun KPIItem(title: String, value: String, onClick: ()->Unit) {
    Card(modifier = Modifier.weight(1f).height(80.dp), elevation = CardDefaults.cardElevation(6.dp)) {
        Column(modifier = Modifier.fillMaxSize().padding(8.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(title, style = MaterialTheme.typography.bodySmall)
            Text(value, style = MaterialTheme.typography.titleLarge)
        }
    }
}

@Composable
fun SubjectBar(color: Color, subject: String, progressText: String, modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth().height(56.dp).background(MaterialTheme.colorScheme.surfaceVariant), verticalAlignment = Alignment.CenterVertically) {
        Box(modifier = Modifier.size(16.dp).background(color, shape = CircleShape).padding(4.dp))
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(subject, style = MaterialTheme.typography.titleMedium)
            LinearProgressIndicator(progress = 0.35f, modifier = Modifier.fillMaxWidth().padding(end = 16.dp))
        }
        Text(progressText, modifier = Modifier.padding(start = 8.dp))
    }
}
