package com.example.Employee.model;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document
public class Employee {
    @Id
    private String empId;
    @NotBlank(message = "name is required")
    private String name;
    @Positive(message = "age must be a positive number")
    private String age;
    private String position;
    private String salary;

}
