package com.chamalwr.main;

import java.util.Map;
import java.util.HashMap;

public class HashMapBasics {
    public static void main(String[] args){

        Map<String, String> personalDetail_Map = new  HashMap<>();

        personalDetail_Map.put("Name", "Chamal");
        personalDetail_Map.put("AGE", "21");
        personalDetail_Map.put("Language 1", "Java");
        personalDetail_Map.put("Language 2", "C++");

        System.out.println(personalDetail_Map);

        String name = personalDetail_Map.get("Name");
        System.out.println("The name of the user is " + name);

    }
}
