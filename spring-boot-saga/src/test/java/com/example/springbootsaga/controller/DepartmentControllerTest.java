package com.example.springbootsaga.controller;

import com.example.springbootsaga.entity.Department;
import com.example.springbootsaga.error.DepartmentNotFoundException;
import com.example.springbootsaga.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    public void setUp(){
        department = Department.builder()
                .departmentAddress("Mumbai")
                .departmentId(1L)
                .departmentName("CS")
                .departmentCode("CS01")
                .build();
    }
    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .departmentAddress("Mumbai")
                .departmentName("CS")
                .departmentCode("CS01")
                .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);

        mockMvc.perform(post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"departmentName\": \"CS\",\n" +
                        "    \"departmentAddress\": \"Mumbai\",\n" +
                        "    \"departmentCode\": \"CS01\"\n" +
                        "}\n"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void fetchDepartmentById() throws Exception {

        Mockito.when(departmentService.fetchDepartmentById(1L))
                .thenReturn(department);

        mockMvc.perform(get("/departments/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"departmentName\": \"CS\",\n" +
                        "    \"departmentAddress\": \"Mumbai\",\n" +
                        "    \"departmentCode\": \"CS01\"\n" +
                        "    \"departmentId\": \"1\"\n" +
                        "}\n"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}