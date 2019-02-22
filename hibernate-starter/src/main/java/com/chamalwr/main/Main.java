package com.chamalwr.main;

import com.chamalwr.func.CrudFunctions;
import com.chamalwr.model.Student;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        CrudFunctions crudFunctions = new CrudFunctions();

        /** Saving students (after saving one change emails - because emails are unique field in database) */
        Student student0 = new Student("Chathura", "Wijekoon", "chathura@email.aus");
        Student student1 = new Student("Kalana", "G.D", "Kalana@email.com");

        crudFunctions.saveStudent(student0, student1);


        /**Retrieve specific student from the database */
        Student findStudent = crudFunctions.getStudent(6);

        if(findStudent != null){
            System.out.println(findStudent.toString());
        }else{
            System.out.println("Student is not found!");
        }


        /** Retrieve all the students from Database */
        List<Student> students = crudFunctions.getStudents();

        if(students != null){
            for (Student student : students){
                System.out.println(student.toString());
            }
        }else {
            System.out.println("Table is empty!");
        }

        /** Retrieve data based on given query */
        List<Student> query_result = crudFunctions.getStudentsByQuery();

        if(query_result != null){
            for (Student student : query_result){
                System.out.println(student.toString());
            }
        }else{
            System.out.println("No Data Found!");
        }

        /** Update students email by using student id */
        crudFunctions.updateStudent(4, "rimshan@xoom.lk");


        /** Delete a student by ID */
        crudFunctions.deleteStudentById(4);
        crudFunctions.deleteStudent_Method2(3);
    }

}
