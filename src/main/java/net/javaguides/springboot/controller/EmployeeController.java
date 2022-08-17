package net.javaguides.springboot.controller;


import net.javaguides.springboot.EmployeeRepository;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping ("/api/v1/employees")
public class EmployeeController {


    @Autowired
    private EmployeeRepository employeeRepository;


    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    //build create employee REST api
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);

    }

    //Build get employee by rest APi
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee Doesnot exist with id= " + id));
        return ResponseEntity.ok(employee);
    }

    //Build update employee rest api
    @PutMapping("(id)")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails) {
        Employee updateEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee doesnot exist with id:" + id));

        updateEmployee.setFirstname(employeeDetails.getFirstname());
        updateEmployee.setLastname(employeeDetails.getLastname());
        updateEmployee.setEmailid(employeeDetails.getEmailid());

        employeeRepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);
    }

    //Delete employee rest API
    @DeleteMapping(("id"))
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with id =" +id));

        employeeRepository.delete(employee);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}


