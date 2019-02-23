package com.chamalwr.ioop.main;

import java.io.BufferedInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


public class Main {
    private static final String FILE_LINK = "https://www.gnu.org/licenses/gpl-3.0.txt";
    private static final String SAVE_FILE  = "files/GNU3.0.txt";

    public static void main(String[] args) throws IOException{

        InputStream ips = null;
        BufferedInputStream bfStream = null;
        FileWriter fwrite =null;

        try{
            fwrite = new FileWriter(SAVE_FILE);
            URL fileURL = new URL(FILE_LINK);
            ips = fileURL.openStream();
            bfStream = new BufferedInputStream(ips);

            StringBuilder sbLink = new StringBuilder();
            int data;
            while(true){
                data = bfStream.read();

                if(data == -1){
                    break;
                }
                else{
                    sbLink.append((char)data);
                }
            }

            System.out.println(sbLink);
            fwrite.write(sbLink + " \n ");
            System.out.println("Saved Path ( FILES/GNU3.0.txt )");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            ips.close();
            bfStream.close();
            fwrite.close();
        }

    }
}
