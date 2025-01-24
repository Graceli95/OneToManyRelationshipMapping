package com.Li;

import com.Li.model.Address;
import com.Li.model.Cohort;
import com.Li.model.Department;
import com.Li.model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.hibernate.mapping.MappingHelper.oneToOne;

public class Main {
    public static void main(String[] args) {
//        oneTOMany();
//       oneToOne();
        manyToMany();
    }

    private static void oneTOMany() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //creating teacher
        Teacher t1 = new Teacher("1000","MHaseeb");
        Teacher t2 = new Teacher("2220","Shahparan");
        Teacher t3 = new Teacher("3000","James");
        Teacher t4 = new Teacher("40000","Joseph");
        Teacher t5 = new Teacher("200","Ali");

        //Add teacher Entity object to the List
        ArrayList<Teacher> teacherList = new ArrayList<>();
        teacherList.add(t1);
        teacherList.add(t2);
        teacherList.add(t3);
        teacherList.add(t4);
        teacherList.add(t5);
        session.persist(t1);
        session.persist(t2);
        session.persist(t3);
        session.persist(t4);
        session.persist(t5);

       //creating Department
        Department department = new Department();
        department.setDeptName("Development");
        department.setTeacherList(teacherList);

        //Storing Department
        session.persist(department);
        transaction.commit();
    }

//    one to one mapping
    public static void oneToOne() {
        System.out.println("Maven + Hibernate + SQL One to One Mapping Annotations");
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Address a1 = new Address("27th street","NYC","NY",11103);
        Address a2 = new Address("28th street","Buffalo","NY",15803);

        Teacher t1 = new Teacher("1000","MHaseeb");
        Teacher t2 = new Teacher("2220","Shahparan");
//        t1.setAddress(a1);
//        t2.setAddress(a2);

        session.persist(a1);
        session.persist(a2);
        session.persist(t1);
        session.persist(t2);

        transaction.commit();
    }

    //many to many mapping
    public static void manyToMany() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //----Create Cohort/class Entity set one----
        Cohort Class1 = new Cohort("Java Developer", "14weeks");
        Cohort Class2 = new Cohort("FullStack Developer", "7 Weeks");
        Cohort Class3 = new Cohort("Python Developer", "12 Weeks");

        //------ Store Cohort / Class --------
        session.persist(Class1);
        session.persist(Class2);
        session.persist(Class3);

        //-----Create Cohort one / Class one --------
        Set<Cohort> ClassSet1 = new HashSet<Cohort>();
        ClassSet1.add(Class1);
        ClassSet1.add(Class2);
        ClassSet1.add(Class3);

        //-----Create Cohort two / Class two --------
        Set<Cohort> ClassSet2 = new HashSet<Cohort>();
        ClassSet2.add(Class2);
        ClassSet2.add(Class3);
        ClassSet2.add(Class1);

        //-----Create Cohort Three / Class Three --------
        Set<Cohort> ClassSet3 = new HashSet<Cohort>();
        ClassSet3.add(Class3);
        ClassSet3.add(Class1);
        ClassSet3.add(Class2);

        Teacher t1 = new Teacher("100", "Haseeb", ClassSet1);
        Teacher t2 = new Teacher("200", "Jenny", ClassSet2);
        Teacher t3 = new Teacher("200", "Charlie", ClassSet3);

        session.persist(t1);
        session.persist(t2);
        session.persist(t3);

        transaction.commit();

    }
}