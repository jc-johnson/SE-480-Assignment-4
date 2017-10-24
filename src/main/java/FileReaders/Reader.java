package main.java.FileReaders;

import main.java.Utils.Constants;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    private List<String> buildStopWords() {

        try {

            List<String> stopWords = new ArrayList<>();

            // Read in file
            FileInputStream fileInputStream = new FileInputStream(Constants.ALICE_FILE);
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
            String strLine;

            //Read File Line By Line
            while ((strLine = bufferedReader.readLine()) != null)   {
                stopWords.add(strLine);
                // System.out.println (strLine);
            }

            for(String string : stopWords) {
                System.out.println(string);
            }

            //Close the input stream
            dataInputStream.close();
            return stopWords;

        } catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }

        return null;
    }

    public static void main(String[] args) {
        try {

            List<String> fileCopy = new ArrayList<>();

            // Read in file
            FileInputStream fileInputStream = new FileInputStream(Constants.ALICE_FILE);
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
