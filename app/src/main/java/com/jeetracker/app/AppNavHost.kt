package com.jeetracker.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jeetracker.app.screens.DashboardScreen
import com.jeetracker.app.screens.LogStudyScreen
import com.jeetracker.app.screens.PomodoroScreen
import com.jeetracker.app.screens.AddTestScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "dashboard") {
        composable("dashboard") { DashboardScreen(navController) }
        composable("log_study") { LogStudyScreen(navController) }
        composable("pomodoro") { PomodoroScreen(navController) }
        composable("add_test") { AddTestScreen(navController) }
    }
}
