package com.Li.model;
import jakarta.persistence.*;

/**
 * ● In a many-to-many association, the source entity has a field that stores a
 * collection of target entities. The @ManyToMany annotation is used to link the
 * source entity with the target entity.
 * ● A many-to-many association always uses an intermediate table called the
 * Join table to store the association that joins two entities. The
 * @JoinTable annotation can be used to specify the table name via the
 * name attribute, as well as to specify the names of the Foreign Key
 * columns. Otherwise, Join tables will be created by default name.
 * ● In this lab, we will only implement unidirectional entity mapping using JPA
 * and Hibernate. We can define the @ManytoMany annotation either in the
 * Class (Cohort) class or Teacher class.
 * Let us consider an example of the relationship between Class (Cohort) and
 * Teacher entities. A Cohort can have many Teachers, and vice-versa, a
 * Teacher can belong to many Cohorts.
 * A join table (teacher_cohort) is required to connect both sides
 */
@Entity
@Table(name = "cohort")
public class Cohort {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cohortId;
    private String cohortName;
    private String duration;


    public Cohort(String cohortName, String duration) {
        this.cohortName = cohortName;
        this.duration = duration;
    }

    public Cohort() {

    }

    public int getCohortId() {
        return cohortId;
    }

    public void setCohortId(int cohortId) {
        this.cohortId = cohortId;
    }

    public String getCohortName() {
        return cohortName;
    }

    public void setCohortName(String cohortName) {
        this.cohortName = cohortName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
