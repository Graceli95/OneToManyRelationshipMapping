package com.Li.model;

import jakarta.persistence.*;


import java.io.Serial;
import java.io.Serializable;

/**
 * ● The @OneToOne annotation is used to map the source entity with the target entity.
 * ● The one-to-one association can be either unidirectional or bidirectional.
 * ○ In unidirectional association, the source entity has a relationship field that
 * refers to the target entity, and the source entity’s table contains the foreign
 * key.
 * ○ In a bidirectional association, each entity (e.g., source and target) has a
 * relationship field that refers to each other, and the target entity’s table
 * contains the foreign key. The source entity must use the mappedBy attribute
 * to define the bidirectional one-to-one mapping.
 * ● In this lab, we will implement only unidirectional entity mapping using
 * Hibernate.
 * Let us consider an example of a relationship between a Person and an Address
 * entity. A person can have one address and that address belongs to one person
 * only. That is a typical example of a one-to-one relationship or association. We
 * will model this in a database, and we will need to store the primary key of the
 * Address record as a foreign key in the Person table.
 */
@Entity
@Table
public class Teacher implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacherId;
    private String salary;
    private String teacherName;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public Teacher(String salary, String teacherName) {
        super();
        this.salary = salary;
        this.teacherName = teacherName;
    }

    public Teacher() {
    }

    public Teacher(String salary, String teacherName, Department department) {
        this.salary = salary;
        this.teacherName = teacherName;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }


}