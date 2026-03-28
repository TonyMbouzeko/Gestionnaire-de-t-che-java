package com.tony.gestionnairedetache.model;
public class Task {

    private String description;
    private boolean completed;
    private long id;
    public Task(String description) {
        this.description = description;
        this.completed = false;
    }

    public String getDescription() {
        return description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return  (completed ? " [X]" : " [ ]") + " " +  id + " - " + description;
    }
    
}
