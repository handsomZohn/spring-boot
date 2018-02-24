package com.neo.service.impl;

import com.neo.entity.Student;
import com.neo.repository.StudentRepository;
import com.neo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getStudentList() {
        return studentRepository.findAll();
        // org.springframework.data.mapping.PropertyReferenceException: No property userName found for type Student!
    }

}


