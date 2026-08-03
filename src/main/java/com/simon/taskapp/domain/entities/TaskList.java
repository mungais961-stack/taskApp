package com.simon.taskapp.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="task_lists")
public class TaskList {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    @Column(name="task_list_id",nullable = false)
    private UUID id;
    @Column(name="title",nullable=false)
    private String title;
    @Column(name="description")
    private String description;

    @OneToMany(mappedBy = "taskList",cascade= {CascadeType.REMOVE,CascadeType.PERSIST})
    private List<Task> task;
    @Column(name="updated",nullable = false)
    private LocalDateTime updated;
    @Column(name="created",nullable = false)
    private LocalDateTime created;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TaskList taskList = (TaskList) o;
        return Objects.equals(id, taskList.id) && Objects.equals(title, taskList.title) && Objects.equals(description, taskList.description) && Objects.equals(task, taskList.task) && Objects.equals(updated, taskList.updated) && Objects.equals(created, taskList.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, task, updated, created);
    }

    @Override
    public String toString() {
        return "TaskList{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", task=" + task +
                ", updated=" + updated +
                ", created=" + created +
                '}';
    }
}
