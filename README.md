======================================
DiaLife - Diabetic Management System
=======================================
## About the Project

DiaLife is a backend application developed to manage diabetes-related healthcare information. The project allows users to manage doctors, patients, health records, medications, prescriptions, appointments, and user roles.
One of the main features of the project is AI-powered health suggestions. The application uses the Groq API to generate general wellness suggestions based on the patient's available health information and recent records.
This project was built to practice and demonstrate real-world backend development concepts using Java, Spring Boot, JPA, Hibernate, and MySQL.

---

## Features

* User management
* Doctor management
* Patient health record management
* Blood glucose record tracking
* Medication management
* Prescription management
* Appointment management
* Role management
* AI-powered health and wellness suggestions
* CRUD operations
* Input validation
* Global exception handling
* MySQL database integration
* RESTful API development
* API testing using Postman

---

## Technologies Used

### Backend

* Java 17
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* Maven

### Database

* MySQL
* MySQL Connector/J

### Tools

* Eclipse IDE
* Postman
* Git
* GitHub
* Lombok

### AI Integration

* Groq API
* Llama 3.1 8B Instant

------------------------

## Project Architecture

The application follows a layered architecture to keep the code organized and maintainable.


Client / Postman
       |
Controller Layer
       |
Service Layer
       |
Repository Layer
       |
JPA / Hibernate
       |
MySQL Database


The main layers used in the project are:

* **Controller** - Handles incoming HTTP requests and sends responses.
* **Service** - Contains the business logic of the application.
* **Repository** - Handles communication with the database.
* **Entity** - Represents the database tables.
* **DTO** - Transfers data between different layers of the application.
* **Exception Handler** - Handles application errors in a centralized way.

---------------------------

## Main Modules

### User Management

This module handles user-related operations such as adding, viewing, updating, and deleting user information.

### Doctor Management

This module manages doctor details and their relationship with patients and other healthcare information.

### Health Record Management

Health records are used to store patient-related health information, including blood glucose readings and other relevant details.

### Medication Management

This module manages medication information associated with patients.

### Prescription Management

Doctors can create and manage prescriptions for patients.

### Appointment Management

This module handles appointments between doctors and patients.

### Role Management

The application supports role management for different types of users, such as administrators, doctors, and patients.

### AI Suggestions

DiaLife integrates with the Groq API to generate personalized wellness suggestions based on available patient health information. The AI feature is intended to provide general suggestions and does not replace professional medical advice.

----------------------------------------

## Database Configuration

Create a MySQL database:

Sql:
CREATE DATABASE dialife;

Then configure the database details in "application.properties".

properties:
spring.datasource.url=jdbc:mysql://localhost:3306/dialife
spring.datasource.username=YOUR_MYSQL_USERNAME
spring.datasource.password=YOUR_MYSQL_PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect

server.port=8080


Replace "YOUR_MYSQL_USERNAME" and "YOUR_MYSQL_PASSWORD` with your local MySQL credentials".

-----------------------------------------------

## Groq API Configuration

The project uses the Groq API for generating AI-powered health suggestions.

Configure the following properties:

properties:
-----------
groq.api.key=${GROQ_API_KEY}
groq.api.url=https://api.groq.com/openai/v1/chat/completions
groq.api.model=llama-3.1-8b-instant


The API key should be stored as an environment variable:


"GROQ_API_KEY"


For security reasons, the actual API key should not be added directly to the GitHub repository.

---

## How to Run the Project

### 1. Clone the repository

git clone YOUR_GITHUB_REPOSITORY_URL


### 2. Open the project

Open the project in Eclipse IDE or any Java IDE that supports Maven and Spring Boot.

### 3. Create the database

Create the MySQL database:


CREATE DATABASE dialife;


### 4. Configure application.properties

Update the MySQL username and password in:

src/main/resources/application.properties


### 5. Set the "Groq API key"

Create an environment variable named:

GROQ_API_KEY


Add your Groq API key as its value.

### 6. Run the application

Run the main Spring Boot application class:


DiaLifeApplication.java


You can also run the project using Maven:


mvn spring-boot:run


The application will start on:


http://localhost:8080


## API Testing

The APIs were tested using Postman.

The application contains REST APIs for managing:

Users
Doctors
Health Records
Medications
Prescriptions
Appointments
Roles
AI Suggestions


The exact API endpoints depend on the request mappings defined in the controllers.

-------------------------------------------------------

## Concepts Used in the Project

This project includes practical implementation of:

* Java
* Object-Oriented Programming
* Spring Boot
* REST APIs
* CRUD operations
* Spring Data JPA
* Hibernate
* MySQL
* DTO pattern
* Layered architecture
* Entity relationships
* Input validation
* Global exception handling
* Environment variables
* External API integration
* AI-powered suggestions
* Git and GitHub

-------------------------------

## Future Improvements

Some features that can be added in the future include:

* JWT-based authentication
* Complete role-based authorization
* Secure login and password encryption
* React frontend integration
* Separate dashboards for administrators, doctors, and patients
* Blood glucose reports and analytics
* Charts for tracking health records
* Medication reminders
* Appointment notifications
* Improved AI health insights
* Docker support
* Cloud deployment

---------------------------

## Author

**Abishek**

Java Full Stack Developer | Fresher

**Skills:** Java, Spring Boot, Spring Data JPA, Hibernate, MySQL, REST APIs, Maven, Postman, Git and GitHub.

------------------------------------

## Project Purpose

DiaLife was developed as a learning and portfolio project to gain practical experience in backend development.

Through this project, I worked with REST API development, database integration, layered architecture, entity relationships, exception handling, and external API integration. The project also gave me experience in integrating an AI service with a Spring Boot application.

The main goal of DiaLife is to demonstrate my understanding of building a structured backend application using Java and Spring Boot.

