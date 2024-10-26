# Student Management API

Welcome to the **Student Management API**! This project is built using **Spring Boot** and **JPA** to manage student records in a database. It provides a set of RESTful APIs for performing CRUD operations on student data.

## Features
- **Create** a new student
- **Retrieve** all students or a specific student by ID and name
- **Update** student information completely or partially
- **Delete** a student by name

## Technologies Used
- **Java**: The programming language for the project
- **Spring Boot**: Framework for building the API
- **Spring Data JPA**: For database interaction
- **MySQL**: Relational database for storing student records

## Getting Started

### Prerequisites
- **Java 11+**
- **Maven**
- **MySQL** or any compatible database

API Endpoints

Method	Endpoint	Description
POST -->	/api/std/save	-> Add a new student
GET	--> /api/std/all	-> Get all students
GET	--> /api/std -> Get a student by ID and name
PUT	--> /api/std/{id}	-> Fully update a student by ID
PATCH	--> /api/std/{id}	-> Partially update student by ID
DELETE --> /api/std/name/{name}	-> Delete student by name
