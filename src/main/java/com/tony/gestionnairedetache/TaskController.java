package com.tony.gestionnairedetache;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")

public class TaskController {

    private TaskManager taskManager = new TaskManager();

    @GetMapping
    public List<Task> getTasks() {
        return taskManager.getTasks();
    }

    //@RequestBody est utilisé pour indiquer que les données de la tâche seront envoyées dans le corps de la requête HTTP. Cela permet au client de fournir les détails de la tâche (comme la description) lors de l'ajout d'une nouvelle tâche via une requête POST.
    @PostMapping
    public void addTask(@RequestBody Task task){
        taskManager.addTask(task);
    }

    //ResponseEntity est utilisé pour construire une réponse HTTP plus flexible. Dans ce cas, si la tâche à supprimer n'est pas trouvée, on retourne une réponse avec le statut 404 Not Found. Si la suppression est réussie, on retourne une réponse avec le statut 204 No Content, indiquant que la requête a été traitée avec succès mais qu'il n'y a pas de contenu à retourner.
    //build() est une méthode statique de ResponseEntity qui crée une instance de ResponseEntity avec le statut HTTP spécifié. Dans ce cas, notFound().build() crée une réponse avec le statut 404 Not Found, tandis que noContent().build() crée une réponse avec le statut 204 No Content.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable long id) {
        if (!taskManager.deleteTask(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable long id) {
        Task task = taskManager.getTaskbyId(id);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task>updateTask(@RequestBody Task task, @PathVariable long id) {
        Task updatedTask = taskManager.updateTask(id, task);
        if (updatedTask == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedTask);
    }


}
