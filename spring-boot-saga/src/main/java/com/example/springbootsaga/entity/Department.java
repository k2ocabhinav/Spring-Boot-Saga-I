package com.example.springbootsaga.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.message.Message;

@Entity
@Data //Lombok: Getters/Setters/toString
@NoArgsConstructor //Default Constructors
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    @NotBlank(message = "Please add department name")
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;


}
