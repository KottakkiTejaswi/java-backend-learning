package com.tejaswi.taskmanager.controller;

//Handles HTTP requests. This is the API layer of the application. 
// It receives requests from clients, processes them (often by calling service methods), and returns responses. 
// Controllers are typically annotated with @RestController or @Controller.


import com.tejaswi.taskmanager.model.Task;
import com.tejaswi.taskmanager.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Returns JSON directly. 
// If we used @Controller, we would need to use @ResponseBody on each method to indicate that the return value should be serialized to JSON and sent in the response body.
@RequestMapping("/tasks")
// This annotation specifies that all endpoints in this controller will be prefixed with /tasks.
public class TaskController {

    private final TaskService service; // This is a reference to the TaskService, which contains the business logic for managing tasks.

    public TaskController(TaskService service) { // This is a constructor that takes a TaskService as a parameter. 
    // Spring will automatically inject an instance of TaskService when it creates an instance of TaskController (this is called constructor injection).
        this.service = service;// The constructor assigns the injected TaskService to the service field, allowing the controller to use it to handle requests.
    }

    @GetMapping //Handles GET requests to /tasks. 
    // It retrieves a list of all tasks by calling the getAllTasks() method of the TaskService and returns it as a JSON response.
    public List<Task> getAllTasks() {
        return service.getAllTasks();
    }

    @PostMapping //Handles POST requests to /tasks.
        // It creates a new task by accepting a Task object in the request body (deserialized from JSON) and passing it to the createTask() method of the TaskService.
    public void createTask(@RequestBody Task task) {
        // The @RequestBody annotation tells Spring to deserialize the JSON in the request body into a Task object.
        service.createTask(task);
        // The method returns void, which means it will return a 200 OK status with an empty body if the task is created successfully.

    }
}

//Client → Controller → Service → Repository → Data
//                         ↓
//                    Response back

