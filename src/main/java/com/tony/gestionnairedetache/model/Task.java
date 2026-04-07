package com.tony.gestionnairedetache.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @NotBlank(message = "La description de la tâche ne doit pas être vide")
    @Size(min = 3, max = 255, message = " la description de la tâche doit contenir entre 3 et 255 caractères")
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
