package com.example.Employee.service;

import com.example.Employee.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto updateEmployee(EmployeeDto employeeDto);

    String deleteEmployee(String empId);

    List<EmployeeDto> getAllEmployee(String search, String pageNo, String pageSize);

    EmployeeDto getEmployee(String empId);
}
