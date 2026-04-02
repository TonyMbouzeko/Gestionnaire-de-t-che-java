# 📝 Task Manager API

## 🚀 Description

API REST développée avec **Spring Boot** permettant de gérer des tâches (CRUD).

Le projet utilise :

* Spring Boot (backend)
* PostgreSQL (base de données)
* Docker & Docker Compose (containerisation)
* JPA / Hibernate (persistance des données)

---

## ⚙️ Technologies

* Java 17+
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
git clone <your-repo-url>
cd <project-folder>
```

### 2. Lancer les containers

```bash
docker-compose up --build
```

---

## 🌐 Accès

* API : http://localhost:8080/tasks
* pgAdmin : http://localhost:5050

---

## 🧪 Exemple de requête

### POST /tasks

```json
{
  "title": "Apprendre Docker",
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

## ⚙️ Variables d’environnement

Les variables sont définies dans `docker-compose.yml` :

* `SPRING_DATASOURCE_URL`
* `SPRING_DATASOURCE_USERNAME`
* `SPRING_DATASOURCE_PASSWORD`

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
