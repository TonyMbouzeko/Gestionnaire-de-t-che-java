# 📝 Task Manager API

## 🚀 Description

ce projet a pour but de développée une API REST avec **Spring Boot** permettant de gérer des tâches (CRUD).

Le projet utilise :

* Spring Boot (backend)
* PostgreSQL (base de données)
* Docker & Docker Compose (containerisation afin que l'API puisse être lancer dans n'importe quel environnement)
* JPA / Hibernate (Pour la persistance des données)

---

## ⚙️ Technologies

* Java
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Docker / Docker Compose

---

## 📦 Fonctionnalités

* Créer une tâche
* Récupérer toutes les tâches
* Mettre à jour une tâche
* Supprimer une tâche

---

## 🐳 Lancer le projet avec Docker

### 1. Cloner le projet

```bash
git clone https://github.com/TonyMbouzeko/Gestionnaire-de-t-che-java
```

### 2. Lancer les containers

```bash
docker-compose up --build
```

---

## 🌐 Accès

* API : http://localhost:8080/tasks
* pgAdmin : http://localhost:5050
* Swagger : http://localhost:8080/swagger-ui/index.html#/

---

## 🧪 Exemple de requête

### POST /tasks

```json
{
  "title": "Tester l'API de gestion de tâche de Tony",
  "completed": false
}
```

---

## 🗄️ Base de données

* PostgreSQL
* Données persistées via Docker volume

---

## 📁 Structure du projet

```
controller/
service/
repository/
model/
```

---


## 🎯 Objectif

Projet backend complet avec :

* API REST
* base de données
* Docker
* CI/CD (en cours)

---


## 👨‍💻 Auteur

Tony
