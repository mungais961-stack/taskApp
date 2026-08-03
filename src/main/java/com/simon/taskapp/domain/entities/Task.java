package com.simon.taskapp.domain.entities;

import com.simon.taskapp.domain.entities.enums.TaskPriority;
import com.simon.taskapp.domain.entities.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.Getter;

import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;
@Getter
@Setter
@Entity
@Table(name="task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id",nullable = false,updatable = false)
    private UUID id;

    @Column(name="title",nullable = false)
    private String title;

    @Column(name="description")
   private String description;

    @Enumerated(EnumType.STRING)
      @Column(name="task-priority",nullable = false)
    private TaskPriority taskPriority;

    @Enumerated(EnumType.STRING)
     @Column(name="task-status",nullable = false)
    private TaskStatus taskStatus;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="task_list_id")
    private TaskList taskList;

    @Column(name="updated",nullable = false)
    private Instant updated;

    @Column (name="created",nullable=false)
    private Instant created;
    private LocalDate dueDate;

    public Task(UUID id, String title, String description, TaskPriority taskPriority,
                TaskStatus taskStatus, TaskList taskList,Instant updated, Instant created,LocalDate dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.taskPriority = taskPriority;
        this.taskStatus = taskStatus;
        this.taskList = taskList;
        this.updated = updated;
        this.created = created;
        this.dueDate = dueDate;
    }

    public Task() {
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", taskPriority=" + taskPriority +
                ", taskStatus=" + taskStatus +
                ", taskList=" + taskList +
                ", updated=" + updated +
                ", created=" + created +
                '}';
    }
}
