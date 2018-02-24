package com.neo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by zohn on 2018/2/24.
 */
@Entity
public class Student {
    @Column(nullable = false, unique = true)
    private String name;
    @Id
    @GeneratedValue
    private long id; // id

    public long getId() {
        return id;
    }

//    public void setId(long id) {
//        this.id = id;
//    }

    public Student setId(long id) {
        this.id = id;
        return this;
    }


    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

//    public void setName(String name) {
//        this.name = name;
//    }
}
