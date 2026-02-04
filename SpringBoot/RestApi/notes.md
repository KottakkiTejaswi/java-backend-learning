## Spring Boot — REST API Basics

**1. What is a REST API?**

A REST API exposes resources over HTTP using standard verbs.

| HTTP Verb | Meaning   |
| --------- | --------- |
| GET       | read data |
| POST      | create    |
| PUT       | update    |
| DELETE    | remove    |


**Spring maps:**

HTTP request → method call

JSON → Java object

Java object → JSON


**2. Controller Layer (@RestController)**
Responsibility

- handle HTTP requests

- delegate to service layer

- return response

📌 Controllers should not contain business logic.

**3. Service Layer (@Service)**

Responsibility

- business logic

- decision making

- orchestration 

**4. DTO (Data Transfer Object)**

Why DTOs exist

- separate API contract from domain logic

- avoid exposing internals

- control response shape

**5. End-to-End Flow (Mental Model)**


- Client calls /hello

- Spring routes request → controller

- Controller calls service

- Service returns DTO

- Spring converts DTO → JSON

```

{
  "message": "Hello from Spring Boot!"
}


```

