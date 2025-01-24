package com.Li.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * Cascade=CascadeType.ALL: Any change that happens to the teacher must cascade
 * to the department as well. If you save a Teacher, all associated accounts will also be
 * saved into the database. If you delete a Teacher, all accounts associated with that
 * Teacher will also be deleted.
 *
 * targetEntity=Teacher.class: It is used to determine the entity class that is
 * the target of the association.
 * targetEntity: Specify the entity class that is the target of the association.
 * This is optional only if the collection property is defined using Java generics;
 * otherwise, it must be specified.
 */

/**
 * In a one-to-many relationship, each row of one entity is referenced by many child
 * records in another entity. The important thing is that children's records cannot have
 * multiple parents. In a one-to-many relationship between Table A and Table B, each row
 * in Table A is linked to 0, 1, or many rows in Table B.
 */

@Entity
@Table
public class Department implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deptId;
    private String deptName;

    @OneToMany(targetEntity = Teacher.class, cascade = CascadeType.ALL) //We wanted to save the mapped entity whenever the relationship owner entity is saved.To enable this, we had to use the “CascadeType” attribute.
    private List<Teacher> teacherList;

    public Department(int deptId, String deptName) {
        super();
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public Department() {}

    public Department(String deptName) {
        this.deptName = deptName;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }
}
