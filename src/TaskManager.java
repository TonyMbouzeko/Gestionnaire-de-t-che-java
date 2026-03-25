package src;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import src.Task;

public class TaskManager {

    private ArrayList<Task> tasks;
    private long nextId = 1;
    
    public TaskManager() {
        tasks = new ArrayList<>();
    }

// dans le getTasks, on retourne une nouvelle liste pour éviter que l'utilisateur puisse modifier directement la liste interne du TaskManager.
    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }

//FileWriter est utilisé pour écrire les tâches dans un fichier texte. Chaque tâche est écrite sur une nouvelle ligne, avec son état de complétion, son id, et sa description, séparés par un caractère "|". Cela permet de sauvegarder les tâches de manière structurée et facilement lisible.
    static void saveTasks(ArrayList<Task> tasks) {
        FileWriter writer;
        try {
            writer = new FileWriter("data/tasks.txt");
            for (Task task : tasks) {
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
    static void loadTasks(ArrayList<Task> tasks) {
        try (BufferedReader fileScanner = new BufferedReader(new java.io.FileReader("tasks.txt"))) {
            String line;
            while ((line = fileScanner.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 3) {
                    boolean completed = Boolean.parseBoolean(parts[0]);
                    long id = Long.parseLong(parts[1]);
                    String description = parts[2];
                    Task task = new Task(id, description);
                    task.setCompleted(completed);
                    tasks.add(task);
                }
            }
        } catch (Exception e) {
            System.out.println("Aucune tâche à charger ou erreur lors du chargement : " + e.getMessage());
        }
    }

    public Task addTask(String description) {
        Task task = new Task(nextId++, description);
        tasks.add(task);
        return task;
    }

    public boolean deleteTask(int index) {
        if (isValidIndex(index)) {
            tasks.remove(index-1);
            return true;
        }
        return false;
    }


    public boolean completeTask(int index) {
        if (isValidIndex(index)) {
            tasks.get(index-1).setCompleted(true);
            return true;
        }
        return false; 
    }

    private boolean isValidIndex(int index) {
        return index > 0 && index <= tasks.size();
    }

}
