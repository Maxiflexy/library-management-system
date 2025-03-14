# Library Management System

A comprehensive Java application for managing library resources including books, members, and borrowing records.

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Requirements](#requirements)
- [Installation and Setup](#installation-and-setup)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Technical Implementation](#technical-implementation)

## Overview

This Library Management System is designed to help librarians manage their collections efficiently. The system allows for tracking books, managing library members, handling book borrowing and returns, and generating reports.

## Features

- **Book Management**
    - Add, update, and delete books
    - Search books by title, author, or genre
    - Sort books by title or genre
    - Export book data to CSV

- **Member Management**
    - Add, update, and delete members
    - View all members
    - Export member data to CSV

- **Borrowing Management**
    - Borrow books for members
    - Return books
    - View borrowing history
    - Track currently borrowed books

- **Logging and Reporting**
    - Detailed logging of all operations
    - Export data to CSV files

## Requirements

- Java 11 or higher
- Maven
- PostgreSQL database

## Installation and Setup

### 1. Database Setup

1. Install PostgreSQL if you haven't already
2. Create the database and required tables:

```bash
psql -U postgres -f database_schema.sql
```

This will create the database, tables, and insert some sample data.

### 2. Configure Database Connection

Update the database connection settings in `src/main/resources/config.properties` if needed:

```properties
db.url=jdbc:postgresql://localhost:5432/library_db
db.username=postgres
db.password=postgres
db.driver=org.postgresql.Driver
```

### 3. Build the Project

Navigate to the project root directory and use Maven to build the project:

```bash
mvn clean package
```

This will compile the code and create an executable JAR file with all dependencies.

### 4. Run the Application

Execute the JAR file:

```bash
java -jar target/library-management-system-1.0.1-jar-with-dependencies.jar
```

Alternatively, run the main class directly:

```bash
java -cp target/classes com.maxiflexy.dreamdevs.Main
```

## Usage

After launching the application, you'll see the main menu with these options:

### 1. Book Management
- Add new books to the library
- Update existing book details
- Delete books from the library
- Search for books by title, author, or genre
- View all books or sorted lists
- Export book data to CSV

### 2. Member Management
- Register new library members
- Update member information
- Remove members from the system
- View all registered members
- Export member data to CSV

### 3. Borrowing Management
- Record books borrowed by members
- Process book returns
- View all borrowing records
- Check active borrowings
- See member borrowing history
- View a map of currently borrowed books

### Example Workflow

1. Add new books to the library
2. Register library members
3. Process book borrowings
4. View active borrowing records
5. Process book returns
6. Export data for reporting

## Project Structure

```
library-management-system/
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── library/
│   │   │           ├── Main.java
│   │   │           ├── config/
│   │   │           │   └── DatabaseConnection.java
│   │   │           ├── dao/
│   │   │           │   ├── interfaces/
│   │   │           │   │   ├── BookDAO.java
│   │   │           │   │   ├── MemberDAO.java
│   │   │           │   │   └── BorrowingDAO.java
│   │   │           │   └── impl/
│   │   │           │       ├── BookDAOImpl.java
│   │   │           │       ├── MemberDAOImpl.java
│   │   │           │       └── BorrowingDAOImpl.java
│   │   │           ├── model/
│   │   │           │   ├── Book.java
│   │   │           │   ├── Member.java
│   │   │           │   └── BorrowingRecord.java
│   │   │           ├── service/
│   │   │           │   ├── BookService.java
│   │   │           │   ├── MemberService.java
│   │   │           │   └── BorrowingService.java
│   │   │           ├── util/
│   │   │           │   ├── CSVExporter.java
│   │   │           │   └── Logger.java
│   │   │           └── ui/
│   │   │               ├── LibraryManagementSystem.java
│   │   │               ├── BookManagementUI.java
│   │   │               ├── MemberManagementUI.java
│   │   │               └── BorrowingManagementUI.java
│   │   └── resources/
│   │       ├── config.properties
│   │       └── library_log.txt
```

## Technical Implementation

The application implements several key Java technologies:

### JDBC with DAO Pattern
- Complete separation of database logic from business logic
- Implemented interfaces and classes for data access
- CRUD operations for all entities

### File Handling
- Logging of all system activities to text file
- Export functionality for books and members to CSV files
- Uses BufferedReader and BufferedWriter for efficient I/O operations

### Java Collections Framework
- In-memory caching using ArrayList
- Search functionality with Stream API
- Sorting with Comparable and Comparator
- HashMap for tracking borrowed books

### Error Handling
- Comprehensive exception handling throughout the application
- Detailed logging of all errors
- User-friendly error messages in the UI