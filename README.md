# GraphQL+SpringBoot server
This is a GraphQL server created with Java and Spring Boot framework.

## Table of Content
- [Tech Stack](#tech-stack)
- [Installation](#Installation)

## Tech stack:
- Java 24 
- Maven
- Spring Boot 3.5.3
- MySQL 9.3.0
- GraphQL

## Installation
### Prerequisites
To get started, make sure you have the following installed:
- Java 24
- MySQL 9.3.0

### Set up mysql database locally
1. Log into MySQL:
    ```bash
    mysql -u root -p;
    ```
    Enter your password after this command.
2. Create the database used:
    ```bash
    CREATE DATABASE demo;
    ```
3. Switch the current database to the database used:
    ```bash
    USE demo;
    ```
4. Create tables:
    ```bash
    CREATE TABLE users (
        username VARCHAR(255) PRIMARY KEY,
        password VARCHAR(255) NOT NULL
    );

    CREATE TABLE Todos (
        TodoID INT AUTO_INCREMENT PRIMARY KEY,
        TaskText VARCHAR(255) NOT NULL, 
        Status ENUM('Pending', 'Completed') DEFAULT 'Pending',
        CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        username VARCHAR(255),                 
        FOREIGN KEY (username) REFERENCES users(username) ON DELETE CASCADE
    );

    CREATE TABLE Bookmarks (
        id INT AUTO_INCREMENT PRIMARY KEY,   
        name VARCHAR(255) NOT NULL,           
        url VARCHAR(255) NOT NULL,           
        username VARCHAR(255),               
        FOREIGN KEY (username) REFERENCES users(username) ON DELETE CASCADE
    );

    ```
5. Make username unique:
    ```bash
    CREATE UNIQUE INDEX idx_username ON users(username);
    ```
6. 🔧 Adding Your MySQL Username and Password to the Spring Project:
    - Navigate to the resources directory
    ```bash
    cd src/main/resources
    ```

    - Open the "application.properties" file 

    - Locate the following lines
    ```bash
    spring.datasource.username = 
    spring.datasource.password = 
    ```

    - Enter your MySQL credentials
    ```bash
    spring.datasource.username = root
    spring.datasource.password = yourPasswordHere
    ```

    - Save the file
