package com.simon.taskapp.mappers.impl;

import com.simon.taskapp.domain.dto.CreateTaskRequestDto;
import com.simon.taskapp.domain.dto.TaskDto;
import com.simon.taskapp.domain.dto.UpdateTaskRequestDto;
import com.simon.taskapp.domain.entities.Task;
import com.simon.taskapp.mappers.TaskMapper;
import com.simon.taskapp.service.CreateTaskRequest;
import com.simon.taskapp.service.UpdateTaskRequest;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {
    @Override
    public CreateTaskRequest fromDto(CreateTaskRequestDto dto) {
        return new CreateTaskRequest(
                dto.title(),
                dto.description(),
                dto.dueDate(),
                dto.priority()
        );
    }

    @Override
    public UpdateTaskRequest fromDto(UpdateTaskRequestDto dto) {
        return new UpdateTaskRequest(
                dto.title(),
                dto.description(),
                dto.dueDate(),
                dto.priority(),
                dto.status()
        );
    }

    @Override
    public TaskDto toDto(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getTaskPriority(),
                task.getTaskStatus()
        );
    }


}
