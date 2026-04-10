package com.tony.gestionnairedetache;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tony.gestionnairedetache.exception.ApiError;
import com.tony.gestionnairedetache.model.Task;
import com.tony.gestionnairedetache.service.TaskService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")

public class TaskController {

   private final TaskService taskService;

   public TaskController(TaskService taskService){
    this.taskService = taskService; 
   }


   // ----------------------------------------Annotation pour Swagger (Documentation de l'Api -----------------------

    @Operation(summary = "Récupérer toutes les tâches" , description = "Retourne la liste complète des tâches.")
    @ApiResponse(responseCode = "200", description = "Liste des tâches retournée avec succès.")
    @ApiResponse(
    responseCode = "500",
    description = "Erreur interne du serveur lors de la récupération des tâches.",
    content = @Content(
        mediaType = "application/json",
        schema = @Schema(implementation = ApiError.class)
    )
)
   //----------------------------------------------------------------------------------------------------------------
    @GetMapping
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }

    @Operation(summary = "Récupérer une tâche par id" , description = "Retourne une tâche grâce à son ID.")
    @ApiResponse(responseCode = "200", description = "Tâche retournée avec succès.")
    @ApiResponse(
    responseCode = "500",
    description = "Erreur interne du serveur lors de la récupération de la tâche.",
    content = @Content(
        mediaType = "application/json",
        schema = @Schema(implementation = ApiError.class)
    )
    )
    @ApiResponse(
        responseCode = "404",
        description = "Tâche non trouvée",
        content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = ApiError.class)
        )
    )
    @GetMapping("/{id}")
    public Task getTask(@PathVariable long id){
        return taskService.getTask(id);
    }

    //@RequestBody est utilisé pour indiquer que les données de la tâche seront envoyées dans le corps de la requête HTTP. Cela permet au client de fournir les détails de la tâche (comme la description) lors de l'ajout d'une nouvelle tâche via une requête POST.
    
   
    @Operation(summary = "Créer une tâche" , description = "Crée une nouvelle tâche à partir des données fournies dans le corps de la requête.")
    @ApiResponse(responseCode = "201", description = "Tâche créée avec succès.")
    @ApiResponse(
    responseCode = "400",
    description = "Requête invalide ou données incorrectes",
    content = @Content(
        mediaType = "application/json",
        schema = @Schema(implementation = ApiError.class)
    )
    )
    @ApiResponse(
    responseCode = "500",
    description = "Erreur interne du serveur lors de la création de la tâche",
    content = @Content(
        mediaType = "application/json",
        schema = @Schema(implementation = ApiError.class)
    )
    )
    @PostMapping
    public Task addTask( @Valid @RequestBody Task task){
        return taskService.createTask(task);
    }

    @Operation(summary = "Modifier une tâche" , description = "Met à jour une tâche existante à partir des données fournies dans le corps de la requête.")
    @ApiResponse(responseCode = "200", description = "Tâche modifiée avec succès.")
    @ApiResponse(
    responseCode = "400",
    description = "Requête invalide ou données incorrectes",
    content = @Content(
        mediaType = "application/json",
        schema = @Schema(implementation = ApiError.class)
    )
    )
    @ApiResponse(
        responseCode = "404",
        description = "Tâche non trouvée",
        content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = ApiError.class)
        )
    )
    
    @ApiResponse(
    responseCode = "500",
    description = "Erreur interne du serveur lors de la modification de la tâche",
    content = @Content(
        mediaType = "application/json",
        schema = @Schema(implementation = ApiError.class)
    )
    )
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable long id, @Valid @RequestBody Task task){
        return taskService.editTask(id, task);
    }



    //ResponseEntity est utilisé pour construire une réponse HTTP plus flexible. Dans ce cas, si la tâche à supprimer n'est pas trouvée, on retourne une réponse avec le statut 404 Not Found. Si la suppression est réussie, on retourne une réponse avec le statut 204 No Content, indiquant que la requête a été traitée avec succès mais qu'il n'y a pas de contenu à retourner.
    //build() est une méthode statique de ResponseEntity qui crée une instance de ResponseEntity avec le statut HTTP spécifié. Dans ce cas, notFound().build() crée une réponse avec le statut 404 Not Found, tandis que noContent().build() crée une réponse avec le statut 204 No Content.
    @Operation(summary = "Supprimer une tâche" , description = "Supprime une tâche existante à partir de son identifiant.")
    @ApiResponse(responseCode = "204", description = "Tâche supprimée avec succès.")
    @ApiResponse(
        responseCode = "404",
        description = "Tâche non trouvée",
        content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = ApiError.class)
        )
    )
    @ApiResponse(
    responseCode = "500",
    description = "Erreur interne du serveur lors de la suppression de la tâche",
    content = @Content(
        mediaType = "application/json",
        schema = @Schema(implementation = ApiError.class)
    )
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

  

   /*  @GetMapping("/{id}")
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
*/

}
