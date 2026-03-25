package src;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import src.Task;

public class TaskManager {

    private ArrayList<Task> tasks;
    
    public TaskManager() {
        tasks = new ArrayList<>();
    }

// dans le getTasks, on retourne une nouvelle liste pour éviter que l'utilisateur puisse modifier directement la liste interne du TaskManager.
    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }


    static void saveTasks(ArrayList<Task> tasks) {
        FileWriter writer;
        try {
            writer = new FileWriter("data/tasks.txt");
            for (Task task : tasks) {
                writer.write(task.isCompleted() + "|" + task.getDescription() + "\n");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Erreur lors de la sauvegarde des tâches : " + e.getMessage());
        }
    }

    static void loadTasks(ArrayList<Task> tasks) {
        try (BufferedReader fileScanner = new BufferedReader(new java.io.FileReader("tasks.txt"))) {
            String line;
            while ((line = fileScanner.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 2) {
                    boolean completed = Boolean.parseBoolean(parts[0]);
                    String description = parts[1];
                    Task task = new Task(description);
                    task.setCompleted(completed);
                    tasks.add(task);
                }
            }
        } catch (Exception e) {
            System.out.println("Aucune tâche à charger ou erreur lors du chargement : " + e.getMessage());
        }
    }

    public Task addTask(String description) {
        Task task = new Task(description);
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
