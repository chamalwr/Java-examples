package com.chamalwr.main;

import java.util.Map;
import java.util.HashMap;

public class MapBasicOperations {

    public static void main(String[] args){

        Map<Integer, String> cities = new HashMap<>();

        cities.put(1, "Galle");
        cities.put(2, "Ella");
        cities.put(3, "Arugambay");
        cities.put(4, "Kandy");

        System.out.println(cities);

        cities.put(5, "Kurunegala");
        System.out.println(cities);

        //removing the element at 5th place
        cities.remove(5);
        System.out.println(cities);

        //get city by id
        System.out.println(cities.get(2));

    }
}
