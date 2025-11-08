Library Management System

A Library Management System built with Spring Boot and MongoDB, implementing CRUD operations along with custom queries to manage books efficiently.

Features

Add a new book to the library.

Retrieve all books.

Fetch a book by its ID.

Update book details.

Delete a book by its ID.

Find books by their publication year.

Get the genre of a specific book by its ID.

Delete all books published in a specific year.

Technologies Used

Java 17 (or latest)

Spring Boot

Spring Data MongoDB

MongoDB

Lombok (to reduce boilerplate code)

Maven (for project management)

Postman (for testing REST APIs)

Project Setup
1. Clone the Repository
git clone https://github.com/your-username/library-management-system.git
cd library-management-system

2. Configure MongoDB

Open src/main/resources/application.properties and add your MongoDB configuration:

spring.data.mongodb.uri=mongodb://localhost:27017/librarydb
spring.data.mongodb.database=librarydb
server.port=8081


Make sure MongoDB is running locally or replace the URI with your MongoDB Atlas connection string.

3. Build and Run the Application

If using Maven Wrapper:

./mvnw spring-boot:run   # Linux/Mac
mvnw.cmd spring-boot:run  # Windows


The application will start on http://localhost:8081.

API Endpoints
Method	Endpoint	Description
POST	/books	Add a new book
GET	/books	Retrieve all books
GET	/books/{id}	Get book details by ID
PUT	/books/{id}	Update book details
DELETE	/books/{id}	Delete a book by ID
GET	/books/year/{year}	Find books by publication year
GET	/books/{id}/genre	Get genre of a specific book
DELETE	/books/year/{year}	Delete all books published in a year
Project Structure
src/main/java/com/example/library
│
├── controller
│   └── BookController.java        # REST API endpoints
│
├── model
│   └── Book.java                  # Book entity
│
├── repository
│   └── BookRepository.java        # MongoRepository interface
│
├── service
│   ├── BookService.java           # Service interface
│   └── BookServiceImpl.java       # Service implementation
│
└── LibraryManagementApplication.java  # Spring Boot main class

How to Use

Start the Spring Boot application.

Use Postman or any API client to test the endpoints.

Perform CRUD operations and custom queries as per your requirements.

Contribution

Fork the repository.

Create a feature branch (git checkout -b feature/feature-name).

Commit your changes (git commit -m 'Add some feature').

Push to the branch (git push origin feature/feature-name).

Open a Pull Request.
