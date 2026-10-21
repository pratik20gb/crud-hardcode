# Java Task Manager

A lightweight task management REST API built using **Core Java**, without Spring Boot or external web frameworks.

This project is a hands-on exercise in Java fundamentals, HTTP request handling, and building a backend from scratch.

## Tech Stack

- Java 25
- Built-in Java HTTP Server (`HttpServer`)
- Maven
- In-memory storage (`ArrayList`)

## Features

- Create tasks using HTTP POST
- Retrieve tasks using HTTP GET
- Automatically assign task IDs
- Manage tasks through a dedicated `TaskManager` class
- Send and receive HTTP request/response bodies

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/tasks` | Retrieve all tasks |
| POST | `/tasks` | Create a new task |

**POST request example**

```http
POST http://localhost:8080/tasks
Content-Type: text/plain

Learn Java
```

## Running the Project

1. Clone the repository.
2. Open the project in your Java IDE.
3. Run `TaskServer.java`.
4. Test the API using Postman at `http://localhost:8080/tasks`.

## Project Structure

- `Task.java` — Task model
- `TaskManager.java` — Task management logic
- `TaskServer.java` — HTTP server and API handlers

## Planned Improvements

- Complete and delete tasks through HTTP endpoints
- JSON request and response handling
- Input validation and proper HTTP status codes
- HTML, CSS, and JavaScript frontend
- Persistent storage

## Note

Tasks are currently stored in memory and are lost when the server restarts.