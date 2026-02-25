package com.tejaswi.taskmanager.model;

import java.time.LocalDateTime;



public class Task { 

    private Long id;
    private String title;
    private String description;
    private boolean completed;
    private LocalDateTime createdAt;

    // Default constructor (required for serialization)
    public Task() {
    }

    // Parameterized constructor 
    public Task(Long id, String title, String description,
                boolean completed, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.createdAt = createdAt;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}



//Reflection in Java is a mechanism that allows inspection and manipulation of classes, methods, fields, and annotations at runtime, 
// commonly used by frameworks like Spring for dependency injection and object creation.

//Because Jackson (JSON library) uses reflection to:

//Create object

//Set fields using setters

//Without default constructor → it cannot instantiate object reflectively.

//Serialization is the process of converting an object into a transferable or storable format (such as JSON or byte stream), 
// while deserialization reconstructs the object from that format.


//Reflection enables dynamic object handling, while serialization enables those objects to be transmitted or stored, forming the backbone of REST APIs