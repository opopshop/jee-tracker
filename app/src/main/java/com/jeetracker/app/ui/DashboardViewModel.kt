package com.jeetracker.app.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jeetracker.app.data.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DashboardViewModel(private val repo: Repository): ViewModel() {
    private val _todayHours = MutableStateFlow(0)
    val todayHours: StateFlow<Int> = _todayHours

    fun recalcToday(pid: String) {
        viewModelScope.launch {
            // placeholder: compute from DB
            _todayHours.value = 180 // example 3 hours
        }
    }
}
