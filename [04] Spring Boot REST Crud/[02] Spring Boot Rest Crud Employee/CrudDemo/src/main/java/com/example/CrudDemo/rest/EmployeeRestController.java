package com.example.CrudDemo.rest;

import com.example.CrudDemo.entity.Employee;
import com.example.CrudDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    // Quick and dirty: inject employee dao (use constructor injection)

    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    // expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    // Add mapping for "/employees/{employeeId}"

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId){

        Employee employee = employeeService.findById(employeeId);

        if (employee == null){
            throw new RuntimeException("Employee id: " + employeeId + " not found ");
        }

        return employee;
    }

    // Add mapping for Post "/employees" - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){

        // Just in case they pass an id in JSON, set id to 0
        // this is to force a save of new item instead of an update
        employee.setId(0);

        Employee newEmployee = employeeService.save(employee);

        return newEmployee;
    }

    // Add mapping for Put "/employees" - update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){

        Employee updateEmployee = employeeService.save(employee);

        return updateEmployee;
    }

    // Add mapping for Delete "/employee" - delete an employee

    @DeleteMapping("/employee/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee tempEmployee = employeeService.findById(employeeId);

        // Throw exception if null

        if (tempEmployee == null){
            throw new RuntimeException("Employee id not found: " + employeeId);
        }

        employeeService.delete(employeeId);

        return "Deleted employee id: " + employeeId + "\n with the information " + tempEmployee;
    }

}
