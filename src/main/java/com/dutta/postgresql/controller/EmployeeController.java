package com.dutta.postgresql.controller;

import com.dutta.postgresql.exception.EmployeeNotFoundException;
import com.dutta.postgresql.model.Employee;
import com.dutta.postgresql.repo.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

private EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/addEmployee")
    public String saveEmployee(@RequestBody Employee employee)
    {
        repository.save(employee);
        return "Employee added successfully :"+employee.getName();
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> findALLEmployee()
    {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "employeeId") Integer id)
    {
       Employee employee= repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee Not found :"+id));
       return ResponseEntity.ok().body(employee);
    }

    @PutMapping("/updateEmployee/{employeeId}")
    public ResponseEntity<Employee> updateEmployeeBy(@PathVariable(value = "employeeId") Integer id,@RequestBody Employee employee)
    {
        Employee employee1= repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee Not found :"+id));
        employee1.setName(employee.getName());
        Employee updatedEmployee = repository.save(employee1);
        return ResponseEntity.ok().body(updatedEmployee);
    }


    @DeleteMapping("/deleteEmployee/{employeeId}")
    public ResponseEntity<Employee> deleteEmployeeBy(@PathVariable(value = "employeeId") Integer id)
    {
        Employee employee= repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee Not found :"+id));
        repository.delete(employee);
        return ResponseEntity.ok().build();
    }



}
