package com.tony.gestionnairedetache.model;

import jakarta.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String description;
    private boolean completed;

    public Task(){};
    
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
