package com.tejaswi.taskmanager.controller;

import com.tejaswi.taskmanager.model.Task;
import com.tejaswi.taskmanager.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return service.getAllTasks();
    }

    @PostMapping
    public void createTask(@RequestBody Task task) {
        service.createTask(task);
    }
}
