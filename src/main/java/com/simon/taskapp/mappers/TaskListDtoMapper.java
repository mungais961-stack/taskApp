package com.simon.taskapp.mappers;

import com.simon.taskapp.domain.dto.TaskListDto;
import com.simon.taskapp.domain.entities.TaskList;

public interface TaskListDtoMapper {
    TaskList fromDto(TaskListDto taskListDto);
    TaskListDto toDto(TaskList taskList);
}
