package com.neo.service.impl;

import com.neo.entity.Student;
import com.neo.repository.StudentRepository;
import com.neo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    /**
     * 根据id排序默认是升序、、
     * @return
     */

    @Override
    public List<Student> getStudentList() {
        return studentRepository.findAll(new Sort(Sort.Direction.DESC,"id"));
       //return studentRepository.findAll(new Sort("id"));
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student findStudentById(long id) {
        Student student = studentRepository.findOne(id);
        return student;
    }

    @Override
    public void edit(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void delete(long id) {
        studentRepository.delete(id);
    }

}


