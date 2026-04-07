
package com.tony.gestionnairedetache.exception;

public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException (long id){
        super("la tâche avec l'ID " + id + " n'existe pas.");
    }

    
}