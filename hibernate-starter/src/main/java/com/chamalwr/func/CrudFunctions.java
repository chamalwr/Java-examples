package com.chamalwr.func;

import com.chamalwr.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

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


    public List<Student> getStudents(){

        List<Student> students;

        try{
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Student.class)
                    .buildSessionFactory();

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            students = session.createQuery("from Student").getResultList();
            session.getTransaction().commit();

            return students;

        }catch (Exception err){
            err.printStackTrace();
        }finally {
            if(sessionFactory != null){
                sessionFactory.close();
            }
        }
        return null;
    }

    public List<Student> getStudentsByQuery(){

        List<Student> students;

        try{
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Student.class)
                    .buildSessionFactory();

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            students = session.createQuery("from Student std where std.email LIKE '%email.aus'").getResultList();
            session.getTransaction().commit();
            return students;

        }catch (Exception err){
            err.printStackTrace();
        }finally {
            if(sessionFactory != null){
                sessionFactory.close();
            }
        }
        return null;
    }

    public void updateStudent(int studentID, String email){
        try{
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Student.class)
                    .buildSessionFactory();

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Student student = session.get(Student.class, studentID);
            student.setEmail(email);
            session.getTransaction().commit();
            System.out.println("Student Email updated to : " + email);

        }catch (Exception err){
            err.printStackTrace();
        }finally {
            if(sessionFactory != null){
                sessionFactory.close();
            }
        }
    }

    public void deleteStudentById(int studentID){

        try{
            sessionFactory = new Configuration()
                                 .configure("hibernate.cfg.xml")
                                 .addAnnotatedClass(Student.class)
                                 .buildSessionFactory();

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Student studentToDelete = session.get(Student.class, studentID);
            session.delete(studentToDelete);
            session.getTransaction().commit();
            System.out.println("Student : " +studentToDelete.getFirstName() + " is deleted");
        }catch (Exception err){
            err.printStackTrace();
        }finally {
            if(sessionFactory != null){
                sessionFactory.close();
            }
        }
    }

    public void deleteStudent_Method2(int studentId){
        try{
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Student.class)
                    .buildSessionFactory();

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Query dltQuery = session.createQuery("DELETE from Student WHERE id = :id");
            dltQuery.setParameter("id", studentId);
            dltQuery.executeUpdate();
            session.getTransaction().commit();

        }catch (Exception err){
            err.printStackTrace();
        }finally{
            if(sessionFactory != null){
                sessionFactory.close();
            }
        }

    }

}
