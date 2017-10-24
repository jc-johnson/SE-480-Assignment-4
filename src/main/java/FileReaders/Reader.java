package main.java.FileReaders;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Reader {



    public static void main(String[] args) {
        try {

            // Open the file that is the first
            // command line parameter
            FileInputStream fileInputStream = new FileInputStream("src/main/java/Resources/alice30.txt");

            // Get the object of DataInputStream
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
            String strLine;

            //Read File Line By Line
            while ((strLine = bufferedReader.readLine()) != null)   {
                // Print the content on the console
                System.out.println (strLine);
            }

            //Close the input stream
            dataInputStream.close();

        } catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }
}
