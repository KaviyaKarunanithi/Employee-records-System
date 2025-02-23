package com.example.Employee.repository;
import com.example.Employee.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;
public interface EmployeeRepo extends MongoRepository<Employee,String> {
    @Query("{'name': {$regex: ?0, $options: 'i'}}")
    Page<Employee> findByName(String search, Pageable pageRequest);
}
