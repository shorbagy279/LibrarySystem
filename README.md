
  

# Library Management REST API

  

This project is a **Spring Boot** application for managing a library system, including functionalities for managing books, users, and transactions. It uses **MySQL** as the database and provides a RESTful API for seamless interaction.

  

---

  

## Features

-  **Book Management**: Add, update, view, and delete books.

-  **User Management**: Add, retrieve, and remove users.

-  **Transaction Management**: Handle book borrowing and returning.

-  **Validation**: Prevent operations like issuing books when stock is unavailable.

-  **Status Tracking**: Mark transactions as active or completed.

  

---

  

## Technologies Used

-  **Java**: Core language for the application.

-  **Spring Boot**: Framework for developing the REST API.

-  **MySQL**: Database for storing library data.

-  **Hibernate**: ORM framework for database operations.

-  **Postman**: API testing tool (optional for testing).

-  **GitHub**: Version control.

  

---

  

## Prerequisites

1.  **Java** 17 or above.

2.  **MySQL** database.

3.  **Maven** (to build and run the project).

4. An IDE like **IntelliJ IDEA** or **Eclipse**.

  

---

  

## Setup Instructions

  

### **1. Clone the Repository**

```bash

git  clone  https://github.com/your-username/library-management-api.git

cd  library-management-api

```

  

### **2. Configure the Database**

Create a MySQL database named `library_db` (or any name of your choice).

  

Run the following SQL script to create the necessary tables:

```sql

CREATE  DATABASE  library_db;

  

USE library_db;

  

CREATE  TABLE  book (

id INT  PRIMARY KEY AUTO_INCREMENT,

title VARCHAR(255),

author VARCHAR(255),

in_stock INT

);

  

CREATE  TABLE  user (

id INT  PRIMARY KEY AUTO_INCREMENT,

name  VARCHAR(255),

email VARCHAR(255),

role  VARCHAR(50)

);

  

CREATE  TABLE  transaction (

id INT  PRIMARY KEY AUTO_INCREMENT,

book_id INT,

member_id INT,

issue_date DATE,

return_date DATE,

status  VARCHAR(50),

FOREIGN KEY (book_id) REFERENCES book(id),

FOREIGN KEY (member_id) REFERENCES user(id)

);

```

  

### **3. Update the Configuration**

Modify the `application.properties` file in the `src/main/resources` directory with your MySQL credentials:

```properties

spring.datasource.url=jdbc:mysql://localhost:3306/library_db

spring.datasource.username=your-username

spring.datasource.password=your-password

  

spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

```

  

### **4. Build and Run the Project**

Run the following Maven commands:

```bash

mvn  clean  install

mvn  spring-boot:run

```

  

---

  

## API Endpoints

  

### **Book Management**

-  `GET /api/books`: Get all books.

-  `GET /api/books/{id}`: Get a book by ID.

-  `POST /api/books`: Add a new book or update stock.

-  `DELETE /api/books/{id}`: Delete a book by ID.

  

### **User Management**

-  `GET /api/users`: Get all users.

-  `GET /api/users/{id}`: Get a user by ID.

-  `POST /api/users`: Add a new user.

-  `POST /api/users/bulk`: Add multiple users.

-  `DELETE /api/users/{id}`: Delete a user by ID.

  

### **Transaction Management**

-  `GET /api/transactions`: Get all transactions.

-  `GET /api/transactions/{id}`: Get a transaction by ID.

-  `POST /api/transactions`: Issue a book to a user.

-  `GET /api/transactions/user/{userId}`: Get all transactions for a user.

-  `PUT /api/transactions/return/{transactionId}`: Return a book and update the transaction status.

  

---

  

## Video Demonstration

Watch the full **video demonstration** of the project here: [LinkedIn Post Link](https://www.linkedin.com/feed/update/urn:li:ugcPost:7264938915533348864/).


  

---

  

## Contributing

Contributions are welcome! Feel free to fork this repository and submit a pull request.

  

---

  

## Contact

For any queries or feedback, contact me via [LinkedIn](https://www.linkedin.com/in/shorbagy279/).