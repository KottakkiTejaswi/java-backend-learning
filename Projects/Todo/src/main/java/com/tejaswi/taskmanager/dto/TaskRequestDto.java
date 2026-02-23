package com.tejaswi.taskmanager.dto;

// This DTO is used to receive task data from the client when creating or updating a task. It does not include the task's ID or completion status, as those are managed by the server.

public class TaskRequestDTO {

    private String title;
    private String description;

    // No-args constructor (required for JSON deserialization)
    public TaskRequestDTO() {
    }

    public TaskRequestDTO(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description; 
    }
}
