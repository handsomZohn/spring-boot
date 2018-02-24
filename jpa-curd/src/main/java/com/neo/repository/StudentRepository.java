package com.neo.repository;

import com.neo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * spring data jpa 默认预先生成了一些基本的CURD的方法，例如：增、删、改等等
 *
 * 相当于dao
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

}