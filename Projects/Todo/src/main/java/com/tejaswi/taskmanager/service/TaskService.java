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
        return repository.findAll(); // The findAll() method is a common method provided by Spring Data JPA repositories that retrieves all records from the database table associated with the Task entity and returns them as a list of Task objects.
    }

    public void createTask(Task task) { 
        repository.save(task); 
    }

    public Task updateTask(Long id, Task updatedTask) {
        return repository.findById(id).map(task -> {
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setCompleted(updatedTask.isCompleted());
            // createdAt should not be changed typically
            return repository.save(task);
        }).orElseThrow(() -> new RuntimeException("Task not found with id " + id));
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}
