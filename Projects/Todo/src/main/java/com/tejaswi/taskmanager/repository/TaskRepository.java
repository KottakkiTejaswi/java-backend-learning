package com.tejaswi.taskmanager.repository;

import com.tejaswi.taskmanager.model.Task;
import org.springframework.stereotype.Repository; // This annotation indicates that this class is a repository component in the Spring application. 
// It is a specialization of the @Component annotation, which allows Spring to automatically detect and manage it as a bean in the application context.

import java.util.ArrayList; // This imports the ArrayList class from the java.util package, which is used to create a list of tasks in memory. 
// In a real application, you would typically use a database for data storage, but for simplicity, this example uses an in-memory list.
import java.util.List;

@Repository
public class TaskRepository {

    private final List<Task> tasks = new ArrayList<>(); // This creates an in-memory list to store tasks. 

    public List<Task> findAll() { // This method retrieves all tasks by returning the list of tasks.
        return tasks;
    }

    public void save(Task task) { // This method saves a new task by adding it to the list of tasks.
        tasks.add(task);
    }
}
