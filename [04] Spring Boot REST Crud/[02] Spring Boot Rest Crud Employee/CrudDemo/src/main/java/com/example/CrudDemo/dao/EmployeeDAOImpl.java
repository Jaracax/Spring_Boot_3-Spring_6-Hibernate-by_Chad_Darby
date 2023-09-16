package com.example.CrudDemo.dao;

import com.example.CrudDemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    // Define field for entityManager
    private EntityManager entityManager;

    // Set up constructor injection

    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        // Create a query

        TypedQuery<Employee> typedQuery = entityManager.createQuery("from Employee", Employee.class);

        // Execute a query and get result list
        List<Employee> employees = typedQuery.getResultList();

        // Return the results
        return employees;
    }

    @Override
    public Employee findById(int id) {

        // Get employee by id
        Employee employee = entityManager.find(Employee.class, id);

        // Return employee
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        // Save employee
        Employee newEmployee = entityManager.merge(employee);

        // Return new employee
        return newEmployee;
    }

    @Override
    public void delete(int id) {
        // Find employee by Id
        Employee employeeToDelete = entityManager.find(Employee.class, id);

        // Remove employee
        entityManager.remove(employeeToDelete);
    }
}
