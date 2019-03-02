package com.chamalwr.fileio.main;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        File readFile = new File("src//main//resources//read.txt");
        File writeFile = new File("src//main//resources//write.txt");

        try{
            FileUtils.copyFile(readFile, writeFile);
            System.out.printf("File Copying Complete!");
        }catch(IOException e){
            e.printStackTrace();
        }
        finally{

        }

    }
}
