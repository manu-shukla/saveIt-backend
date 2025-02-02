# SaveIt Backend

## Description

SaveIt Backend is a Spring Boot application that provides RESTful APIs for file upload, download, and management. It
supports various file types and ensures secure handling of file operations.

## How to Use

### Prerequisites

- Java 11 or higher
- Maven 3.6.0 or higher

### Setup

1. Clone the repository:
    ```sh
    git clone https://github.com/your-username/saveit-backend.git
    cd saveit-backend
    ```

2. Build the project:
    ```sh
    mvn clean install
    ```

3. Run the application:
    ```sh
    mvn spring-boot:run
    ```

### API Endpoints

#### Upload a File

- **URL:** `/files/upload`
- **Method:** `POST`
- **Request:** `multipart/form-data` with a file
- **Response:** `200 OK` with file ID

#### Download a File

- **URL:** `/files/{id}`
- **Method:** `GET`
- **Response:** `200 OK` with file content

#### Get All Files

- **URL:** `/files/all`
- **Method:** `GET`
- **Response:** `200 OK` with list of files

#### Delete a File

- **URL:** `/files/{id}`
- **Method:** `DELETE`
- **Response:** `200 OK` on successful deletion

## Technologies Used

- **Java**: Programming language
- **Spring Boot**: Framework for building the application
- **Maven**: Build and dependency management tool
- **Lombok**: Library to reduce boilerplate code
- **Spring Web**: Module for building web applications