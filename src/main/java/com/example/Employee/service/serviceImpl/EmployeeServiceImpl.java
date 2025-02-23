package com.example.Employee.service.serviceImpl;
import com.example.Employee.dto.EmployeeDto;
import com.example.Employee.model.Employee;
import com.example.Employee.repository.EmployeeRepo;
import com.example.Employee.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setAge(employeeDto.getAge());
        employee.setPosition(employeeDto.getPosition());
        employee.setSalary(employeeDto.getSalary());
        employeeRepo.save(employee);
        return employeeDto;
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeRepo.findById(employeeDto.getEmpId()).orElseThrow();
        employee.setName(employeeDto.getName());
        employee.setAge(employeeDto.getAge());
        employee.setPosition(employeeDto.getPosition());
        employee.setSalary(employeeDto.getSalary());
        employeeRepo.save(employee);
        return employeeDto;
    }

    @Override
    public String deleteEmployee(String empId) {
        employeeRepo.deleteById(empId);
        return "employee deleted successFully";
    }

    @Override
    public List<EmployeeDto> getAllEmployee(String search, String pageNo, String pageSize) {
        int page = Integer.parseInt(pageNo) - 1; 
        int size = Integer.parseInt(pageSize);
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Order.asc("name")));
        List<Employee> employees;
        if (search != null && !search.isEmpty()) {
            Page<Employee> employeePage = employeeRepo.findByName(search, pageable);
            employees = employeePage.getContent();
        } else {
            Page<Employee> employeePage = employeeRepo.findAll(pageable);
            employees = employeePage.getContent();
        }
        return employees.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }


    @Override
    public EmployeeDto getEmployee(String empId) {
        Employee employee = employeeRepo.findById(empId).orElseThrow();
        EmployeeDto employeeDto = modelMapper.map(employee,EmployeeDto.class);
        return employeeDto;
    }

    private EmployeeDto convertToDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmpId(employee.getEmpId());
        employeeDto.setName(employee.getName());
        employeeDto.setAge(employee.getAge());
        employeeDto.setPosition(employee.getPosition());
        employeeDto.setSalary(employee.getSalary());
        return employeeDto;
    }
}

