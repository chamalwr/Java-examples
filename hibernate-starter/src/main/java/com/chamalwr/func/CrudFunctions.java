package com.chamalwr.func;

import com.chamalwr.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CrudFunctions {

    private SessionFactory sessionFactory;

    public void saveStudent(Student... students){

        try{
             sessionFactory = new Configuration()
                     .configure("hibernate.cfg.xml")
                     .addAnnotatedClass(Student.class)
                     .buildSessionFactory();


            Session session = sessionFactory.getCurrentSession();

            session.beginTransaction();
            for (Student student : students){
                session.save(student);
                System.out.println("Student : " + student.getFirstName() + " saved successfully");
                System.out.println("Saved id for " + student.getFirstName() + " is " + student.getId());
            }
            session.getTransaction().commit();
        }catch (Exception err){
           err.printStackTrace();
        }finally {
            if(sessionFactory != null){
                sessionFactory.close();
            }
        }
    }


    public Student getStudent(int studentId){
        try{
            sessionFactory = new Configuration()
                                 .configure("hibernate.cfg.xml")
                                 .addAnnotatedClass(Student.class)
                                  .buildSessionFactory();


            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Student student = session.get(Student.class, studentId);
            session.getTransaction().commit();

            return student;

        }catch (Exception err){
            err.printStackTrace();
        }finally {
            if(sessionFactory != null){
                sessionFactory.close();
            }
        }

        return null;
    }

}
