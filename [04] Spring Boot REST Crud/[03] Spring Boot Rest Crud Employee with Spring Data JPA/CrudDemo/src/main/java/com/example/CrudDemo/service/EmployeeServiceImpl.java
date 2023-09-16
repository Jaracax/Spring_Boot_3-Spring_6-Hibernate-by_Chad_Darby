package com.example.CrudDemo.service;

import com.example.CrudDemo.dao.EmployeeRepository;
import com.example.CrudDemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);

        Employee employee = null;

        if (result.isPresent()){
            employee = result.get();
        } else {
            // The employee wasn't found
            throw new RuntimeException("Employee with id: " + id + ", was not found");
        }

        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        Employee employeeToBeDelete = findById(id);
//        employeeRepository.delete(employeeToBeDelete);
        employeeRepository.deleteById(id);
        System.out.println("Employee with id: " + id + "\n with the following information was deleted \n"
                + employeeToBeDelete);
    }
}
