package com.simon.taskapp.service;

import com.simon.taskapp.domain.entities.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    Task createTask(CreateTaskRequest request);

    List<Task>listTasks();

    Task updateTask(UUID id, UpdateTaskRequest request);

    void deleteTask(UUID taskId);
}
