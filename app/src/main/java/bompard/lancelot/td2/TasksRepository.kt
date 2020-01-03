package bompard.lancelot.td2

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import bompard.lancelot.td2.network.Api
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class TasksRepository {
    private val tasksService = Api.taskService


    suspend fun loadTasks(): List<Task>? {
        val tasksResponse = tasksService.getTasks()
        return if (tasksResponse.isSuccessful) tasksResponse.body() else null
    }
    suspend fun addTask(task: Task): Task? {
        val tasksResponse = tasksService.createTask(task)
        return if (tasksResponse.isSuccessful) tasksResponse.body() else null
    }


    suspend fun deleteTask(id: String): Boolean {
        val response = tasksService.deleteTask(id)
        return response.isSuccessful
    }

    suspend fun updateTask(task: Task): Task? {
        val response = tasksService.updateTask(task)
        return if (response.isSuccessful) response.body() else null

    }
}