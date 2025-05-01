
# 🛠️ Task Manager Simulation

A high-performance, Java-based task management system simulating real-world software used in mission-critical environments. Designed to demonstrate **low-latency**, **thread-safe operations**, **logging**, **search optimization**, and **extensibility**—matching enterprise-grade backend engineering expectations.

---

## 🚀 Why This Project?

This project is built specifically to match job roles that require:

- Designing and developing **high-volume, low-latency** applications
- Contributing across the **entire development lifecycle**
- Writing **testable**, **efficient**, and **well-designed** code
- Practicing **CI/CD**, **Maven-based builds**, and **logging**
- Implementing **rate limiting**, **multithreading**, and **search operations**

---

## 🧠 Features

- ✅ Add, View, Update, and Delete Tasks (CRUD)
- 🔍 Search tasks by Priority
- ⚡ Rate limiting for task creation
- 🔁 Thread-safe Singleton-based service
- 📁 Java Logging to Console and File (`java.util.logging`)
- 🧪 JUnit 5 Test Cases with Display Names & Setup/Teardown hooks
- 📦 Deployable as a `.JAR` file via Maven
- 🔄 GitHub Actions for CI/CD builds

---

## 🗂️ Project Structure

```
taskmanager-simulation/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── taskmanager/
│   │           ├── Task.java
│   │           ├── TaskService.java
│   │           ├── TaskRateLimiter.java
│   │           └── Main.java
│   ├── test/
│   │   └── java/
│   │       └── TaskServiceTest.java
│   │           
├── .github/
│   └── workflows/
│       └── build.yml
├── pom.xml
└── README.md
```

---

## 🧪 Testing

JUnit 5 is used for testing:

- ✅ `@DisplayName` annotations for better readability
- ✅ `@BeforeEach`, `@AfterEach`, `@BeforeAll`, `@AfterAll` lifecycle methods
- ✅ Logging test execution to a file using `FileHandler`

Run tests via:

```bash
mvn test
```

---

## 🔨 Build & Run

To compile and package the JAR:

```bash
mvn clean package
```

To run:

```bash
java -jar target/taskmanager-1.0-SNAPSHOT.jar
```

---

## 🔧 GitHub Actions CI/CD

Located in: `.github/workflows/build.yml`

Automatically builds and tests the code on push and PR to `main`.

---

## 📄 Technologies Used

- Java 17+
- Maven
- JUnit 5
- GitHub Actions
- java.util.logging
- Threading and Singleton Patterns

---

## ✅ Future Enhancements

- Add persistence using an embedded DB like H2 or SQLite
- Expose endpoints via a lightweight HTTP server
- Caching layer for improved performance
- Integrate OpenTelemetry for tracing
- Role-based task access simulation

---



> Designed for maximum clarity, structure, and performance.
