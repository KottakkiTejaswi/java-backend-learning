# Task Manager API (Spring Boot)

A simple **Task Manager REST API** built using **Java and Spring Boot** to learn backend fundamentals such as controllers, services, DTOs, repositories, and REST APIs.

This project allows users to create, view, complete, and delete tasks.

---

# 🚀 Tech Stack

* Java
* Spring Boot
* Maven
* REST API
* Embedded Tomcat

---

# 📂 Project Structure

```
Todo/
├── src/main/java/com/tejaswi/taskmanager
│   ├── TaskManagerApplication.java
│   ├── controller
│   │   └── TaskController.java
│   ├── service
│   │   └── TaskService.java
│   ├── repository
│   │   └── TaskRepository.java
│   ├── model
│   │   └── Task.java
│   └── dto
│       ├── TaskRequestDTO.java
│       └── TaskResponseDTO.java
├── src/main/resources
│   └── application.yml
├── pom.xml
└── .gitignore
```

---

# ⚙️ Prerequisites

Make sure the following are installed:

* **Java 17+**
* **Maven**
* **Git**
* An IDE such as IntelliJ IDEA or VS Code

Check installations:

```bash
java -version
mvn -version
```

---

# ▶️ Running the Application

### 1. Clone the repository

```bash
git clone <your-repo-url>
cd task-manager
```

---

### 2. Build the project

```bash
mvn clean install
```

This compiles the project and downloads dependencies.

---

### 3. Run the Spring Boot application

```bash
mvn spring-boot:run
```

OR run the main class from your IDE:

```
TaskManagerApplication.java
```

---

### 4. Verify the server

Once started, you should see logs similar to:

```
Tomcat started on port 8080
Started TaskManagerApplication
```

The API will now be running at:

```
http://localhost:8080
```

---

# 📡 Example API Endpoints

### Create Task

```
POST /tasks
```

Example request body:

```json
{
  "title": "Learn Spring Boot",
  "description": "Understand controllers and services"
}
```

---

### Get All Tasks

```
GET /tasks
```

---

### Mark Task as Completed

```
PUT /tasks/{id}/complete
```

---

### Delete Task

```
DELETE /tasks/{id}
```

---

# 🧠 Learning Goals

This project is designed to practice:

* Spring Boot project structure
* REST API design
* Controllers and Services
* DTO usage
* Model classes
* Dependency Injection
* Basic backend architecture

---

# 📌 Future Improvements

Possible enhancements:

* Add database (PostgreSQL / MySQL)
* Add task priority
* Add due dates
* Add user authentication
* Build a React frontend

---


