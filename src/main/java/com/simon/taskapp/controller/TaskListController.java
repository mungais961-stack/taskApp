package com.simon.taskapp.controller;

import com.simon.taskapp.domain.dto.TaskListDto;

import com.simon.taskapp.domain.entities.TaskList;
import com.simon.taskapp.mappers.TaskListDtoMapper;

import com.simon.taskapp.service.TaskListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(path="/task-list")
public class TaskListController {
    private final TaskListService taskListService;
    private final TaskListDtoMapper taskListMapper;

    @GetMapping
    public List<TaskListDto> getAllTaskLists() {
        return taskListService.getAllTaskLists()
                .stream()
                .map(taskListMapper::toDto).toList();
    }

    @PostMapping
    public TaskListDto createTaskList(@RequestBody TaskListDto taskListDto) {
        TaskList createdTaskList = taskListService
                .createTaskList(taskListMapper.fromDto(taskListDto));

        return taskListMapper.toDto(createdTaskList);

    }

    //to Look at it again
    @GetMapping(path = "/{task-list-id}")
    public TaskListDto getTaskList(@PathVariable("task-list-id") UUID taskListId) {
        return taskListService.getTaskList(taskListId)
                .map(taskListMapper::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Task list with id " + taskListId + " not found"));
    }

    @PutMapping(path = "/{task-list-id}/update")
    public TaskListDto updateTaskList(@PathVariable("task-list-id") UUID taskListId,
                                      @RequestBody TaskListDto taskListDto) {
        TaskList updatedTaskList = taskListService.updateTaskList(taskListId,
                taskListMapper.fromDto(taskListDto));

        return taskListMapper.toDto(updatedTaskList);

    }
}
