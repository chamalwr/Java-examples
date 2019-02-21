package com.chamalwr.main;

import com.chamalwr.func.CrudFunctions;
import com.chamalwr.model.Student;

public class Main {

    public static void main(String[] args) {

        CrudFunctions crudFunctions = new CrudFunctions();

        //Saving students (after saving one change emails - because emails are unique field in database)
        Student student0 = new Student("Isuru", "Harinda", "isuru@email.aus");
        Student student1 = new Student("Rimshan", "Mohomed", "rimshan@email.com");

        crudFunctions.saveStudent(student0, student1);



    }

}
