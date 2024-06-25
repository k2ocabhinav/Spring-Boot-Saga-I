package com.example.springbootsaga.repository;

import com.example.springbootsaga.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
We will be not be implementing a concrete implementation class rather extend the JPA repo itself;
as the JPA gives features to directly interact with the database
*/


@Repository
//Pass the entity and primary key type; <Department, Long>; JPA: Java Persistent API
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    public Department findByDepartmentNameIgnoreCase(String departmentName);
    
}
