package com.chamalwr.func;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class FileOperations {

    private static final String SOURCE_LOCATION = "files/source.txt";
    private static Scanner scn = new Scanner(System.in);
    private static StringBuilder sbData = new StringBuilder();

    public static String readSource(){
        String linkToTheFile = null;

        try(
                FileReader freader = new FileReader(SOURCE_LOCATION);
                BufferedReader bReader = new BufferedReader(freader))
        {
            while(true){
                linkToTheFile = bReader.readLine();
                if(linkToTheFile == null){
                    System.out.println("Empty Content ! No Location Cannot be found");
                    break;
                }
                else{
                    System.out.println("Location Acquired!");
                    break;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return linkToTheFile;
    }



    public static void readFile(String loc)throws MalformedURLException {
        URL fileURL = new URL(loc);

        try(
                InputStream ip = fileURL.openStream();
                BufferedInputStream bfIp = new BufferedInputStream(ip)){

            while(true){
                int data = bfIp.read();
                if(data == -1){
                    break;
                }
                else{
                    sbData.append((char) data);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(sbData);
    }

}
