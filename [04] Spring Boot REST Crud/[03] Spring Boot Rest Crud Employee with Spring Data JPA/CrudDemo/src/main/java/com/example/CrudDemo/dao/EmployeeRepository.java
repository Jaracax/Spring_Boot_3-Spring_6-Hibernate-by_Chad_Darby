package com.example.CrudDemo.dao;

import com.example.CrudDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
