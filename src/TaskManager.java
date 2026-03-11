package src;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import src.Task;

public class TaskManager {

    public static void main(String[] args) {

        ArrayList<Task> tasks = new ArrayList<>();
        loadTasks(tasks);
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n--- Gestionnaire de tâches ---");
            System.out.println("1. Ajouter une tâche");
            System.out.println("2. Voir les tâches");
            System.out.println("3. Supprimer une tâche");
            System.out.println("4. Marquer une tâche comme terminée");
            System.out.println("5. Quitter");

            System.out.print("Choix : ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Entrez la tâche : ");
                    String description = scanner.nextLine();
                    Task task = new Task(description);
                    tasks.add(task);
                    break;

                case 2:
                    System.out.println("\nListe des tâches :");

                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println(i+1 + " - " + tasks.get(i));
                    }
                    break;

                case 3:
                    System.out.print("Numéro de la tâche à supprimer : ");
                    int index = scanner.nextInt();
                    scanner.nextLine();

                    if (index > 0 && index <= tasks.size()) {
                        tasks.remove(index-1);
                    }
                    break;

                case 4:
                    System.out.print("Numéro de la tâche à marquer comme terminée : ");
                    int completeIndex = scanner.nextInt();
                    scanner.nextLine();

                    if (completeIndex > 0 && completeIndex <= tasks.size()) {
                        tasks.get(completeIndex-1).setCompleted(true);
                    }
                    break;

                case 5:
                    scanner.close();
                    saveTasks(tasks);
                    return;

                default:
                    System.out.println("Choix invalide");
            }
        }

        
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
}
