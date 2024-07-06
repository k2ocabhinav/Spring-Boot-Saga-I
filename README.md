# Spring-Boot-Saga

Welcome to **Spring-Boot-Saga**! 🌱 This repository is where I’m documenting my journey of learning Spring Boot. Through this course, I’m diving into the fundamentals and advanced features of Spring Boot development. Here’s what I’m covering:

- 📖 Introduction to Spring Boot and its core concepts
- 🔄 Understanding Dependency Injection and using Spring Initializr
- 🛠️ Setting up development environments with IntelliJ IDEA, STS, and VS Code
- 🚀 Creating and running simple APIs
- 🧰 Leveraging Spring Boot Devtools
- 🏗️ Exploring application architecture and examples
- 💾 Working with H2, JPA, and MySQL for database management
- 🔍 Performing CRUD operations and using Hibernate Validation
- 📝 Adding logging, Project Lombok, and handling exceptions
- ✅ Conducting unit and layer testing
- ⚙️ Configuring application properties and profiles

Join me as I learn and build awesome Spring Boot applications! 🎉


---

### Spring Boot Basics Guide 📚

#### 1. Entity 📝
**Purpose:** Define your data structure.

**Example:**
```java
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String code;
    // Getters and Setters
}
```

#### 2. Repository 🗄️
**Purpose:** Interface to interact with the database.

**Example:**
```java
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
```

#### 3. Service 🛠️
**Purpose:** Define business logic methods.

**Example:**
```java
public interface DepartmentService {
    Department saveDepartment(Department department);
}
```

#### 4. Service Implementation 👨‍💻
**Purpose:** Implement the business logic.

**Example:**
```java
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }
}
```

#### 5. Controller 🚦
**Purpose:** Handle HTTP requests.

**Example:**
```java
@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }
}
```

### Quick Tips:
1. **Entity:** Define your data. 📝
2. **Repository:** Connect to the database. 🗄️
3. **Service:** Write business logic. 🛠️
4. **Service Impl:** Implement the business logic. 👨‍💻
5. **Controller:** Handle incoming requests. 🚦

---
