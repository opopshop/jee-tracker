package com.jeetracker.app.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay

@Composable
fun PomodoroScreen(navController: NavHostController) {
    var running by remember { mutableStateOf(false) }
    var secondsLeft by remember { mutableStateOf(25 * 60) } // default 25 minutes
    LaunchedEffect(running) {
        while (running && secondsLeft > 0) {
            delay(1000L)
            secondsLeft -= 1
        }
        if (secondsLeft == 0) running = false
    }
    Column(modifier = Modifier.fillMaxSize().padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Pomodoro Timer", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(20.dp))
        Text("${'{'}secondsLeft/60{'}'}:${'{'}String.format("%02d", secondsLeft%60){'}'}", style = MaterialTheme.typography.displaySmall)
        Spacer(modifier = Modifier.height(20.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { running = true }) { Text("Start") }
            Button(onClick = { running = false }) { Text("Pause") }
            Button(onClick = { secondsLeft = 25*60 }) { Text("Reset") }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.popBackStack() }) { Text("Done") }
    }
}
