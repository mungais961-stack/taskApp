package com.simon.taskapp.mappers.impl;

import com.simon.taskapp.domain.dto.TaskListDto;
import com.simon.taskapp.domain.entities.enums.TaskStatus;
import com.simon.taskapp.domain.entities.Task;
import com.simon.taskapp.domain.entities.TaskList;
import com.simon.taskapp.mappers.TaskListDtoMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class TaskListMapperImpl implements TaskListDtoMapper {
    private final TaskMapperImpl taskMapper;


    public TaskListMapperImpl(TaskMapperImpl taskMapper) {
        this.taskMapper = taskMapper;

    }

    @Override
    public TaskList fromDto(TaskListDto taskListDto) {
        return new TaskList(
                taskListDto.id(),
                taskListDto.title(),
                taskListDto.description(),
                null,
                //Optional.ofNullable(taskListDto.tasks())
                        //.map(tasks->tasks.stream().map(taskMapper::fromDto)
                               // .toList()).orElse(null),
                null,
                null

        );
    }

    @Override
    public TaskListDto toDto(TaskList taskList) {

        return new TaskListDto(
                taskList.getId(),
                taskList.getTitle(),
                taskList.getDescription(),
                Optional.ofNullable(taskList.getTask())
                        .map(List::size).orElse(0),
                calculateTaskListProgress(taskList.getTask()),
                Optional.ofNullable(taskList.getTask())
                        .map(tasks->tasks.stream().map(
                              taskMapper::toDto
                        ).toList()).orElse(null)

        );
    }
    private Double calculateTaskListProgress(List<Task> tasks){
        if (tasks == null){
            return null;
        }
        long closedTasks = tasks. stream()
                .filter(task->task.getTaskStatus()== TaskStatus.CLOSED)
                .count();
return (double)closedTasks/tasks.size();
    }
}
