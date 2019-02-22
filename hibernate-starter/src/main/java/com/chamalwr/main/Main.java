package com.chamalwr.main;

import com.chamalwr.func.CrudFunctions;
import com.chamalwr.model.Student;

public class Main {

    public static void main(String[] args) {

        CrudFunctions crudFunctions = new CrudFunctions();

        //Saving students (after saving one change emails - because emails are unique field in database)
        Student student0 = new Student("Chathura", "Wijekoon", "chathura@email.aus");
        Student student1 = new Student("Kalana", "G.D", "Kalana@email.com");

        crudFunctions.saveStudent(student0, student1);


        //Retrieve specific student from the database
        Student findStudent = crudFunctions.getStudent(10);

        if(findStudent != null){
            System.out.println(findStudent.toString());
        }else{
            System.out.println("Student is not found!");
        }



    }

}
