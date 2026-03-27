package com.tony.gestionnairedetache;
public class Task {

    private String description;
    private boolean completed;
    private long id;
    public Task(long id, String description) {
        this.description = description;
        this.completed = false;
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public long getId() {
        return id;
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
