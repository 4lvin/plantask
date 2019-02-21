package com.jongjava.task.plantask.dto;

import com.jongjava.task.plantask.models.Task;

import java.util.List;

public class TaskDto {

    private List<Task> tasks;


    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
