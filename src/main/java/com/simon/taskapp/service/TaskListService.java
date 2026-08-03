package com.simon.taskapp.service;

import com.simon.taskapp.domain.entities.TaskList;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskListService {
    public List<TaskList> getAllTaskLists();
    TaskList createTaskList(TaskList taskList);
    Optional<TaskList>getTaskList(UUID id);
    TaskList updateTaskList(UUID taskListId,TaskList taskList);
}
