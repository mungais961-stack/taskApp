package com.simon.taskapp.domain.exceptions;

import java.util.UUID;

public class TaskNotFoundException extends RuntimeException {
    private final UUID id;

    public UUID getId() {
        return id;
    }

    public TaskNotFoundException(UUID id) {
        this.id = id;
        super(String.format("Task with id %s not found", id));

    }
}

