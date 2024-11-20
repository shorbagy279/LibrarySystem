# Library Management REST API

This project is a **Library Management System** implemented as a REST API using **Spring Boot** and **MySQL**. It provides functionality for managing books, users, and transactions like borrowing and returning books.

---

## 🚀 Features

- **Books**: Add, update, delete, and retrieve book details.
- **Users**: Add and manage library members.
- **Transactions**: Handle borrowing and returning of books with automated stock updates.

---

## 🛠️ Technologies Used

- **Java**: Core programming language.
- **Spring Boot**: Framework for building the application.
- **MySQL**: Relational database for storing data.
- **Hibernate**: ORM for database operations.
- **Maven**: Dependency management and build tool.

---

## 📂 Project Structure

```plaintext
src/main/java/com/obaid/RestAPI
├── Controller       # REST controllers for handling requests
├── Entity           # JPA entities for database tables
├── Repository       # Data access layer (DAOs)
├── Service          # Business logic layer
