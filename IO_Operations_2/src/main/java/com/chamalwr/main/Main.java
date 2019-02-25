package com.chamalwr.main;

import com.chamalwr.func.FileOperations;

import java.io.File;
import java.net.MalformedURLException;


public class Main {

    public static void main(String[] args){
        try{
            FileOperations.readFile(FileOperations.readSource());
            FileOperations.writeFile(sbData);

        }catch(MalformedURLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    }

}
