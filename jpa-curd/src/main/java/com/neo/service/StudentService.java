package com.neo.service;

import com.neo.entity.Student;
import com.neo.entity.User;

import java.util.List;

public interface StudentService {

    List<Student> getStudentList();

    void save(Student student);

    Student findStudentById(long id);

    void edit(Student student);
}
