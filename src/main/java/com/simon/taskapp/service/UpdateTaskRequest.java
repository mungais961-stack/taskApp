package com.simon.taskapp.service;

import com.simon.taskapp.domain.entities.enums.TaskPriority;
import com.simon.taskapp.domain.entities.enums.TaskStatus;

import java.time.LocalDate;

public record UpdateTaskRequest(
        String title,
        String description,
        LocalDate dueDate,
        TaskPriority priority,
        TaskStatus status
) {
}
