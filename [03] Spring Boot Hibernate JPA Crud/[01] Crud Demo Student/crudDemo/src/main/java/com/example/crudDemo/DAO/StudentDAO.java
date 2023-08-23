package com.example.crudDemo.DAO;

import com.example.crudDemo.Entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student student);

    void delete (int id);

    int deleteAll();
}
