package src;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        TaskManager taskManager = new TaskManager();
        

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
                    taskManager.addTask(description);
                    break;

                case 2:
                    System.out.println("\nListe des tâches :");

                    for (Task task : taskManager.getTasks()) {
                        System.out.println(task);
                    }
                    break;

                case 3:
                    System.out.print("Numéro de la tâche à supprimer : ");
                    int index = scanner.nextInt();
                    scanner.nextLine();

                    if (taskManager.deleteTask(index)) {
                        System.out.println("Tâche supprimée avec succès.");
                    } else {
                        System.out.println("Numéro de tâche invalide.");
                    }
                    
                    break;

                case 4:
                    System.out.print("Numéro de la tâche à marquer comme terminée : ");
                    int completeIndex = scanner.nextInt();
                    scanner.nextLine();

                    if (taskManager.completeTask(completeIndex)) {
                        System.out.println("Tâche marquée comme terminée.");
                    } else {
                        System.out.println("Numéro de tâche invalide.");
                    }
                    break;

                case 5:
                    scanner.close();
                    taskManager.saveTasks();
                    return;

                default:
                    System.out.println("Choix invalide");
            }
        }

    }
    
}
