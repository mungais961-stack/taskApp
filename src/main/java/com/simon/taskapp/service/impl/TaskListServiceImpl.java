package com.simon.taskapp.service.impl;

import com.simon.taskapp.domain.entities.TaskList;
import com.simon.taskapp.repositories.TaskListRepository;
import com.simon.taskapp.service.TaskListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskListServiceImpl implements TaskListService {

    private final TaskListRepository taskListRepository;

    @Override
    public List<TaskList> getAllTaskLists() {
        return taskListRepository.findAll();
    }

    @Override
    public TaskList createTaskList(TaskList taskList) {
        //We gave the database permission to create IDs for us so you cannot create a taskList which already has an Id
        //Validate
        if (null != taskList.getId()) {
            throw new IllegalArgumentException("taskList already has an Id");
        }
        if (null == taskList.getTitle() || taskList.getTitle().isBlank()) {
            throw new IllegalArgumentException("taskList must have a title");
        }
        LocalDateTime now = LocalDateTime.now();
        return taskListRepository.save(new TaskList(
                null,
                taskList.getTitle(),
                taskList.getDescription(),
                null,
                now,
                now


        ));
    }

    @Override
    public Optional<TaskList> getTaskList(UUID id) {
        return taskListRepository.findById(id);
    }

    @Override
    public TaskList updateTaskList(UUID taskListId, TaskList taskList) {
        if (null == taskList.getId()) {
            throw new IllegalArgumentException("TaskList must have an Id");
        }
        if (!Objects.equals(taskList.getId(), taskListId)) {
            throw new IllegalArgumentException("Attempting to change sensitive information not permitted");
        }
            TaskList existingTaskList = taskListRepository.findById(taskListId)
                    .orElseThrow(()->new IllegalArgumentException("TaskList not found"));
            existingTaskList.setTitle(taskList.getTitle());
            existingTaskList.setDescription(taskList.getDescription());
            existingTaskList.setUpdated(LocalDateTime.now());
            return taskListRepository.save(existingTaskList);

        }


    }

