package com.example.viikkotehtava4.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.viikkotehtava4.model.Task
import com.example.viikkotehtava4.viewmodel.TaskViewModel

@Composable
fun addTaskDialog(viewModel: TaskViewModel, onClose:()-> Unit,onUpdate: (Task)-> Unit){
    var title by remember { mutableStateOf("title") }
    var description by remember { mutableStateOf("description") }
    var dueDate by remember { mutableStateOf("") }

    val tasks by viewModel.tasks.collectAsState()
    val nextid = tasks.size + 1
    var task by remember {
        mutableStateOf(Task(id = 0, title = "", description = "", priority = 1, dueDate = "", done = false))
    }
    AlertDialog(
        onDismissRequest = onClose,
        title= {Text("addTask")},
        text = {
            Column {
                TextField(value = title, onValueChange = {title= it}, label = {Text("add a title")})
                TextField(value = description, onValueChange = {description= it}, label = {Text("add a description")})
                TextField(value = dueDate, onValueChange = {dueDate= it},label = {Text("add a dueDate")}, placeholder = { Text("year-month-day") })

            }
        },
        confirmButton = {
            Button(onClick = {
                val newtask = Task(id= nextid,title=title,description=description,priority=1, dueDate=dueDate, done = false)
                println("taski:"+task)
                viewModel.addTask(newtask)
                onClose()
            }) { Text("save")}
        },
        dismissButton = {
            Button(onClick = {
                onClose()
            }) {Text("cancel") }
        }


    )
}