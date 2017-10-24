package main.java.FileReaders;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Reader {



    public static void main(String[] args) {
        try {

            List<String> fileCopy = new ArrayList<String>();

            // Read in file
            FileInputStream fileInputStream = new FileInputStream("src/main/java/Resources/alice30.txt");
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
            String strLine;

            //Read File Line By Line
            while ((strLine = bufferedReader.readLine()) != null)   {
                fileCopy.add(strLine);
                // System.out.println (strLine);
            }

            for(String string : fileCopy) {
                System.out.println(string);
            }

            //Close the input stream
            dataInputStream.close();

        } catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }
}