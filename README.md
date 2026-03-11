# Gestionnaire de tâches (Java)

Ce projet est une application console développée en Java permettant de gérer une liste de tâches.

## Fonctionnalités

L'application permet de :
- Ajouter une nouvelle tâche
- Afficher la liste des tâches
- Supprimer une tâche
- Marquer une tâche comme terminée
- Sauvegarder les tâches dans un fichier
- Charger automatiquement les tâches au démarrage du programme

Les tâches sont enregistrées dans un fichier texte afin de conserver les données entre les exécutions du programme.

## Technologies utilisées

- Java
- Programmation orientée objet (POO)
- Structures de données (ArrayList)
- Lecture et écriture de fichiers (File I/O)

## Structure du projet

task-manager-java
|
|----src
|   |----Task.java
|   |----TaskManager.java
|----data
|   |----task.txt
| 
|----README.md


## Fonctionnement

Au démarrage du programme :
1. Les tâches enregistrées dans le fichier `tasks.txt` sont chargées.
2. Un menu interactif permet à l'utilisateur de gérer les tâches.
3. Lorsque l'utilisateur quitte le programme, les tâches sont sauvegardées automatiquement.

## Auteur
Tony MBOUZEKO
Projet réalisé dans le cadre de l’apprentissage du langage Java et des concepts de programmation orientée objet.
