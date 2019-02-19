package com.chamalwr.main;

import com.chamalwr.func.Hash;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hash hash = new Hash();

        System.out.print("Enter Your Text to be hashed\n> ");
        String hashedText = hash.hashText(scanner.nextLine());

        System.out.println("Hashed Text \n > " + hashedText);

    }
}
