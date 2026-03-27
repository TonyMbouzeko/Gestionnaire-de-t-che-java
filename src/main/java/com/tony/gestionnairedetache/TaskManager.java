package com.tony.gestionnairedetache;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class TaskManager {

    private ArrayList<Task> tasks;
    private long nextId = 1;

    
    public TaskManager() {
        tasks = new ArrayList<>();
        loadTasks();
    }

// dans le getTasks, on retourne une nouvelle liste pour éviter que l'utilisateur puisse modifier directement la liste interne du TaskManager.
    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }

//FileWriter est utilisé pour écrire les tâches dans un fichier texte. Chaque tâche est écrite sur une nouvelle ligne, avec son état de complétion, son id, et sa description, séparés par un caractère "|". Cela permet de sauvegarder les tâches de manière structurée et facilement lisible.
    public void saveTasks() {
        FileWriter writer;
        try {
            writer = new FileWriter("data/tasks.txt");
            for (Task task : this.tasks) {
                writer.write(task.isCompleted() + "|" + task.getId() + "|" + task.getDescription() + "\n");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Erreur lors de la sauvegarde des tâches : " + e.getMessage());
        }
    }


    /* Pour charger les tâches on a utiliser BufferedReader pour lire le fichier ligne par ligne,
    puis on split chaque ligne en utilisant le caractère "|" comme séparateur. On parse ensuite la première partie pour obtenir
    l'état de complétion de la tâche et on utilise la deuxième partie comme description de la tâche.
    Enfin, on crée une nouvelle instance de Task avec ces informations et on l'ajoute à la liste des tâches.*/
    public void loadTasks() {
        try (BufferedReader fileScanner = new BufferedReader(new java.io.FileReader("data/tasks.txt"))) {
            String line;
            while ((line = fileScanner.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 3) {
                    boolean completed = Boolean.parseBoolean(parts[0]);
                    long id = Long.parseLong(parts[1]);
                    String description = parts[2];
                    Task task = new Task(description);
                    task.setId(id);
                    task.setCompleted(completed);
                    this.tasks.add(task);
                }
            }
            updateNextId();
        } catch (Exception e) {
            System.out.println("Aucune tâche à charger ou erreur lors du chargement : " + e.getMessage());
        }
    }

    public Task addTask(Task task) {
        task.setId(nextId++);
        tasks.add(task);
        return task;
    }

    /*ICi j'utilise Iterator.remove pour retirer la tâche que l'itérateur pointe actuellement, ce qui est plus sûr que de modifier la liste directement pendant l'itération. 
    La méthode retourne true si une tâche a été supprimée avec succès, ou false si aucune tâche avec l'id spécifié n'a été trouvée.*/
    public boolean deleteTask(long id) {
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getId() == id) {
                iterator.remove();
                return true;
            }  
        }
        return false;
    }


    public boolean completeTask(long id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setCompleted(true);
                return true;
            }
        }
        return false; 
    }



    public Task getTaskbyId(long id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null; 
    }
    

public Task updateTask(long id, Task task) {
   Task updatedTask = getTaskbyId(id);
    if (updatedTask == null) {
        return null; 
    }
    updatedTask.setDescription(task.getDescription());
    updatedTask.setCompleted(task.isCompleted());
    return updatedTask;
}

/*lorsque je fais loadTasks, je dois m'assurer que le nextId est mis à jour pour éviter les conflits d'id lors de l'ajout de nouvelles tâches.
 La méthode updateNextId parcourt toutes les tâches chargées pour trouver le plus grand id utilisé, puis met à jour nextId pour qu'il soit supérieur à ce maximum.*/
   private void updateNextId() {
    long maxId = 0;

    for (Task task : tasks) {
        if (task.getId() > maxId) {
            maxId = task.getId();
        }
    }
    nextId = maxId + 1;
    }
}
