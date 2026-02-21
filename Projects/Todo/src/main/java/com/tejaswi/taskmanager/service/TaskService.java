package com.tejaswi.taskmanager.service;

import com.tejaswi.taskmanager.model.Task;
import com.tejaswi.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service; // This annotation indicates that this class is a service component in the Spring application. 
// It is a specialization of the @Component annotation, which allows Spring to automatically detect and manage it as a bean in the application context.
//  Services typically contain business logic and are used by controllers to handle requests.

import java.util.List;

@Service 
public class TaskService {

    private final TaskRepository repository; // This is a reference to the TaskRepository, which is responsible for data access operations related to tasks.

    public TaskService(TaskRepository repository) { // This is a constructor that takes a TaskRepository as a parameter.
        this.repository = repository; // Spring will automatically inject an instance of TaskRepository when it creates an instance of TaskService (this is called constructor injection).
    }

    public List<Task> getAllTasks() { // This method retrieves a list of all tasks by calling the findAll() method of the TaskRepository and returns it.
        return repository.findAll();
    }

    public void createTask(Task task) {
        repository.save(task);
    }
}
