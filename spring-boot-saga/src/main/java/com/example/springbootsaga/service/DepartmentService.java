package com.example.springbootsaga.service;


import com.example.springbootsaga.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();
}
