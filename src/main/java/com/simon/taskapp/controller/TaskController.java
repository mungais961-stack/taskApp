package com.simon.taskapp.controller;

import com.simon.taskapp.domain.dto.CreateTaskRequestDto;
import com.simon.taskapp.domain.dto.TaskDto;
import com.simon.taskapp.domain.dto.UpdateTaskRequestDto;
import com.simon.taskapp.domain.entities.Task;
import com.simon.taskapp.mappers.TaskMapper;
import com.simon.taskapp.service.CreateTaskRequest;
import com.simon.taskapp.service.TaskService;
import com.simon.taskapp.service.UpdateTaskRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path="/api/v1/tasks")
public class TaskController {
    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }
    @PostMapping(path="/create-tasks")
    public ResponseEntity<TaskDto> createTask(@Valid
                                              @RequestBody
                                              CreateTaskRequestDto
                                                      createTaskRequestDto){
        CreateTaskRequest createTaskRequest = taskMapper.fromDto(createTaskRequestDto);
        Task task = taskService.createTask(createTaskRequest);
        TaskDto createdTask = taskMapper.toDto(task);
        return new ResponseEntity<>(createdTask,HttpStatus.CREATED);

    }
    @GetMapping(path="/list-tasks")
    public ResponseEntity<List<TaskDto>>listTasks(){
        List<Task> tasks = taskService.listTasks();
        List<TaskDto> list = tasks.stream().map(taskMapper::toDto).toList();
        return ResponseEntity.ok(list);
    }
    @PutMapping(path="/{taskId}/update-tasks")
    public ResponseEntity<TaskDto>updateTasks(
            @PathVariable UUID taskId,
            @Valid
            @RequestBody UpdateTaskRequestDto updateTaskRequestDto){
        UpdateTaskRequest updateTaskRequest = taskMapper.fromDto(updateTaskRequestDto);
        Task updatedTask = taskService.updateTask(taskId, updateTaskRequest);
        TaskDto dto = taskMapper.toDto(updatedTask);
        return ResponseEntity.ok(dto);

    }
    @DeleteMapping(path="/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable UUID taskId){
        taskService.deleteTask(taskId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
