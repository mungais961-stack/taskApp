package com.simon.taskapp.mappers;

import com.simon.taskapp.domain.dto.CreateTaskRequestDto;
import com.simon.taskapp.domain.dto.TaskDto;
import com.simon.taskapp.domain.dto.UpdateTaskRequestDto;
import com.simon.taskapp.domain.entities.Task;
import com.simon.taskapp.service.CreateTaskRequest;
import com.simon.taskapp.service.UpdateTaskRequest;

public interface TaskMapper {
    CreateTaskRequest fromDto(CreateTaskRequestDto dto);

    UpdateTaskRequest fromDto(UpdateTaskRequestDto dto);

    TaskDto toDto(Task task);


}
