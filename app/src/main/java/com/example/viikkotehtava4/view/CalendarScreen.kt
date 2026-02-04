package com.example.viikkotehtava4.view

import android.R.color.black
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.viikkotehtava4.viewmodel.TaskViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarScreen(viewModel: TaskViewModel, onNavigateHome:()-> Unit){
    val tasks by viewModel.tasks.collectAsState()
    val selectedTask by viewModel.selectedTask.collectAsState()

    val grouped = tasks.groupBy { it.dueDate }

    Column() {
        TopAppBar(
            title = { Text("calendar") },
            navigationIcon = {
                IconButton(onClick = onNavigateHome) {
                    Icon(Icons.Filled.List, contentDescription = "Go to list")
                }

            }

        )

            LazyColumn {

                grouped.forEach { (date, tasksOfDay) ->


                        item {//width = 2.dp, brush = gradientBrush, shape = CircleShape
                                Text(text = date, style= TextStyle(textDecoration = TextDecoration.Underline),)

                        }
                        items(tasksOfDay) { task ->
                            Card(modifier = Modifier.padding(2.dp).fillMaxWidth()) {

                                Column(modifier = Modifier.clickable { viewModel.selectTask(task) }) {
                                    Text(
                                        text = "Title: ${task.title} \n ${task.description}"

                                    )
                                }
                            }


                        }
                    }
                }



    }
    if(selectedTask!=null){
        DetailDialog(viewModel=viewModel, task = selectedTask!!, onClose = {viewModel.closeDialogWindow()}, onUpdate = {viewModel.updateTask(it)})
    }
}