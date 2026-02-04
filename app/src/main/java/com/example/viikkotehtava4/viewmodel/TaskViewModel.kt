package com.example.viikkotehtava4.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.collections.plus
import com.example.viikkotehtava4.model.*
class TaskViewModel: ViewModel() {
    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks
    private val _selectedTask = MutableStateFlow<Task?>(null)
    val selectedTask: StateFlow<Task?> = _selectedTask

    val addTaskDialogVisible = MutableStateFlow<Boolean>(false)
    init {
        _tasks.value = mockData
    }
    fun addTask(newTask: Task){
        _tasks.value += newTask
        addTaskDialogVisible.value = false
    }
    fun toggleDone(id:Int){
        _tasks.value = _tasks.value.map{
            if(it.id == id){
                it.copy(done = !it.done)
            }else{
                it
            }
        }
    }
    fun filterByDone(done: Boolean)
    {
        _tasks.value = _tasks.value.filter { it.done == done }
    }
    fun selectTask(task:Task){
        _selectedTask.value = task
    }
    fun sortByDueDate(){
        _tasks.value = _tasks.value.sortedBy { it.dueDate }
    }
    fun removeTask(id:Int){
        _tasks.value = _tasks.value.filter { it.id!=id}
    }
    fun updateTask(updated:Task){
        _tasks.value = tasks.value.map {
            if(it.id == updated.id) updated else it

        }
        _selectedTask.value = null
    }
    fun closeDialogWindow(){
        _selectedTask.value = null
    }
}