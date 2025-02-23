package com.example.Employee.controller;

import com.example.Employee.dto.EmployeeDto;
import com.example.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @PostMapping("/createEmployee")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        return ResponseEntity.ok(employeeService.createEmployee(employeeDto));
    }
    @PutMapping("/updateEmployee")
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto){
        return ResponseEntity.ok(employeeService.updateEmployee(employeeDto));
    }
    @DeleteMapping("/deleteEmployee")
    public ResponseEntity<String> deleteEmployee(@RequestParam String empId){
        return ResponseEntity.ok(employeeService.deleteEmployee(empId));
    }
    @GetMapping("/getAllEmployee")
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(@RequestParam String search, @RequestParam String pageNo, @RequestParam String pageSize){
        return ResponseEntity.ok(employeeService.getAllEmployee(search,pageNo,pageSize));
    }
    @GetMapping("/getEmployee")
    public ResponseEntity<EmployeeDto> getEmployee(String empId){
        return ResponseEntity.ok(employeeService.getEmployee(empId));
    }
}
