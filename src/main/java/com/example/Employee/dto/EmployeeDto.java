package com.example.Employee.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.Id;
@Data
public class EmployeeDto {
    @Id
    private String empId;
    @NotBlank(message = "name is required")
    private String name;
    private String age;
    private String position;
    private String salary;
}
