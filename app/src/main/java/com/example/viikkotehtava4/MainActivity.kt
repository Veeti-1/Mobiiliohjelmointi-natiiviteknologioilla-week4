package com.example.viikkotehtava4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.viikkotehtava4.navigation.CALENDAR_ROUTE
import com.example.viikkotehtava4.navigation.HOME_ROUTE
import com.example.viikkotehtava4.navigation.SETTINGS_ROUTE
import com.example.viikkotehtava4.ui.theme.Viikkotehtava4Theme
import com.example.viikkotehtava4.view.*
import com.example.viikkotehtava4.viewmodel.TaskViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val viewModel: TaskViewModel = viewModel()

            NavHost(
                startDestination = HOME_ROUTE,
                navController = navController

            ) {
                composable(HOME_ROUTE) {
                    viewModelHomeScreen(
                        viewModel= viewModel,
                        onNavigateCalendar = {
                        navController.navigate(CALENDAR_ROUTE)
                    }, onNavigateSettings = {
                        navController.navigate(SETTINGS_ROUTE)
                        })

                }
                composable(CALENDAR_ROUTE) {
                    CalendarScreen(
                        viewModel=viewModel,
                        onNavigateHome = {
                            navController.navigate(HOME_ROUTE)
                        }
                    )
                }
                composable(SETTINGS_ROUTE) {
                    SettingsScreen(onNavigateHome = {
                        navController.navigate(HOME_ROUTE)
                    }  )
                }


            }
        }
    }
}

