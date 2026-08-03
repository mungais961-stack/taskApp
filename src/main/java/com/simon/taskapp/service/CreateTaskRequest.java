package com.simon.taskapp.service;

import com.simon.taskapp.domain.entities.enums.TaskPriority;

import java.time.LocalDate;

public record CreateTaskRequest(
        String title,
        String description,
        LocalDate dueDate,
        TaskPriority priority
) {
}
