# 📚 Library Management Microservice System

A scalable and production-ready **Library Management System** built using **Spring Boot Microservices Architecture**. The application is designed with service discovery, API Gateway routing, DTO-based communication, and standardized API responses to demonstrate modern enterprise application development practices.

-------------

## 🚀 Project Overview

This project consists of independent microservices that collaborate to manage library operations such as book management and rental management.

The system follows industry-standard microservice design principles including:

* Service Discovery using Eureka Server
* API Gateway for centralized routing
* DTO-based data transfer
* Standardized Response Wrapper pattern
* RESTful API design
* Database persistence using MySQL
* Loose coupling and independent service deployment

---

## 🏗️ Microservices Architecture

```text
                    +------------------+
                    | Client / Postman |
                    +--------+---------+
                             |
                             | HTTP Requests
                             v
                   +---------------------+
                   |     API Gateway     |
                   |      Port 8080      |
                   +----------+----------+
                              |
             Dynamic Routing via Eureka Discovery
                              |
        +---------------------+---------------------+
        |                                           |
        v                                           v

+-------------------+                 +-------------------+
|   BOOK SERVICE    |                 | RENTAL SERVICE    |
|     Port 8081     |                 |     Port 8082     |
+---------+---------+                 +---------+---------+
          |                                     |
          v                                     v

+-------------------+                 +-------------------+
|   Service Layer   |                 |   Service Layer   |
+---------+---------+                 +---------+---------+
          |                                     |
          v                                     v

+-------------------+                 +-------------------+
| DTO & Wrappers    |                 | DTO & Wrappers    |
+---------+---------+                 +---------+---------+
          |                                     |
          v                                     v

+-------------------+                 +-------------------+
|     MySQL DB      |                 |     MySQL DB      |
+-------------------+                 +-------------------+

                    ^
                    |
          +--------------------+
          |   Eureka Server    |
          |      Port 8761     |
          +--------------------+
```

---

## 🛠️ Tech Stack

### Backend

* Java 21
* Spring Boot 
* Spring Cloud

### Microservices Components

* Spring Cloud Gateway
* Eureka Discovery Server
* Eureka Discovery Client

### Database

* MySQL

### Data Access

* Spring Data JPA
* Hibernate ORM

### API Development

* REST APIs
* DTO Pattern
* Response Wrapper Pattern

### Build & Dependency Management

* Maven

### Testing Tools

* Postman

### Development Tools

* Spring Tool Suite (STS)
* IntelliJ IDEA
* Git & GitHub

---

## ✨ Key Features

### 📖 Book Service

* Add Books
* View Books
* Update Book Details
* Delete Books

### 🔄 Rental Service

* Create Rental Records
* Track Rentals
* Manage Book Rentals

### 🌐 API Gateway

* Centralized API Entry Point
* Request Routing
* Load Balancing Support

### 🔍 Eureka Service Discovery

* Automatic Service Registration
* Dynamic Service Discovery
* Improved Scalability

### 📦 DTO & Response Wrapper

* Clean API Contracts
* Consistent API Responses
* Better Client Integration

---

## 📂 Project Structure

```text
library-management-microservice

├── eureka-server
├── api-gateway
├── book-service
├── rental-service
└── README.md
```

---

## 🔧 Services & Ports

| Service        | Port |
| -------------- | ---- |
| Eureka Server  | 8761 |
| API Gateway    | 8080 |
| Book Service   | 8081 |
| Rental Service | 8082 |

---

## 📚 Concepts Demonstrated

* Microservices Architecture
* Service Discovery
* API Gateway Pattern
* RESTful Web Services
* DTO Pattern
* Response Wrapper Pattern
* Layered Architecture
* Dependency Injection
* Database Integration
* Spring Cloud Ecosystem

---

## 🎯 Learning Outcomes

This project demonstrates practical experience with:

* Enterprise Application Development
* Spring Boot Microservices
* Distributed System Design
* API Gateway Routing
* Service Discovery with Eureka
* Database Integration using JPA/Hibernate
* Clean Code and Layered Architecture
* Git Version Control

---

## 👨‍💻 Author

**Ashwin Murugan**
Passionate about Java, Spring Boot, Cloud Technologies, and Microservices Architecture.
