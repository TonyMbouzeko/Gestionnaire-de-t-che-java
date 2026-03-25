package src;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        

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
    
}
