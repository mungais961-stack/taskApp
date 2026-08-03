package com.simon.taskapp.service.impl;

import com.simon.taskapp.domain.entities.enums.TaskStatus;
import com.simon.taskapp.domain.entities.Task;
import com.simon.taskapp.domain.exceptions.TaskNotFoundException;
import com.simon.taskapp.repositories.TaskRepository;
import com.simon.taskapp.service.CreateTaskRequest;
import com.simon.taskapp.service.TaskService;
import com.simon.taskapp.service.UpdateTaskRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {
 private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(CreateTaskRequest request) {
        Instant now = Instant.now();
        Task task = new Task(
                null,
                request.title(),
                request.description(),
                request.priority(),
                TaskStatus.OPEN,
                null,
                now,
                now,
                request.dueDate()
        );
        return taskRepository.save(task);
    }

    @Override
    public List<Task> listTasks() {

        return taskRepository.findAll(Sort.by(Sort.Direction.ASC,"created"));
    }

    @Override
    public Task updateTask(UUID id, UpdateTaskRequest request) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setTaskPriority(request.priority());
        task.setTaskStatus(request.status());
        task.setDueDate(request.dueDate());
        task.setUpdated(Instant.now());

        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(UUID taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException(taskId));
        taskRepository.delete(task);
    }
}