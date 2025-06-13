# 🏢 Compay - Company Department & Employee Management API

This is a simple Spring Boot application for managing departments and employees in a company. It exposes RESTful APIs to create departments, add employees, and assign department heads.

---

## 🚀 Tech Stack

- **Java 21**
- **Spring Boot 3.5.0**
    - Spring Web
    - Spring Data JPA
- **PostgreSQL** (as the relational database)
- **Maven** (for build and dependency management)
- **JUnit 5 & Mockito** (for unit testing)

---

## 📁 Project Structure

```
src/
├── main/
│ ├── java/org/example/compay/
│ │ ├── controller/
│ │ ├── model/ 
│ │ ├── repository/
│ │ └── CompayApplication.java
│ └── resources/
│ └── application.properties
├── frontend/employee-frontend/src #react+vite with default configarutions
│ ├── components/
│ ├── index.html
│ ├── App.jsx
├── test/
│ └── java/org/example/compay/
    ├──DepartmentControllerTest
    ├──EmployeeControllerTest
```

---

## ⚙️ Prerequisites

- Java 21 installed
- Maven installed (`mvn -v`)
- PostgreSQL database running

---

## 🧪 Database Setup

Create a PostgreSQL database (e.g., `compaydb`) and add the following to your `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/{db_name}
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## ▶️ Running the Application

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/compay.git
   cd compay
   ```

2. Run using Maven:
   ```bash
   mvn spring-boot:run
   ```

3. Or build the JAR:
   ```bash
   mvn clean install
   java -jar target/compay-0.0.1-SNAPSHOT.jar
   ```
4. After starting the server
    ``` bash
    cd src\frontend\employee-frontend
    npm install axios react-router-dom
    npm run dev
   ```
---

## 🧪 Running Tests

Unit tests for the controllers are written using JUnit 5 and Mockito. To execute all tests:

```bash
mvn test
```

---

## 🔗 API Endpoints

| Method | Endpoint                             | Description                           |
|--------|--------------------------------------|---------------------------------------|
| GET    | `/departments`                       | Get all departments                   |
| POST   | `/departments`                       | Create a new department               |
| PUT    | `/departments/{deptId}/head/{empId}` | Assign a department head              |
| GET    | `/employees`                         | Get all employees                     |
| POST   | `/employees`                         | Create a new employee                 |
| PUT    | `/employees/{id}`                    | Update the employee with the given ID |
| Delete | `/employees/{id}`                    | Delete the employee with the given ID |
| GET    | `/employees/{id}`                    | Get employee with the given ID        |
---

## 📌 Notes

- `spring-boot-devtools` is included for automatic restarts during development.
- `ResourceNotFoundException` is thrown for missing department or employee.
- Uses constructor-based dependency injection and repository abstraction via JPA.

---

