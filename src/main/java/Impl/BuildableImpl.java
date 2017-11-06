package main.java.Impl;

import main.java.Interfaces.Buildable;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BuildableImpl implements Buildable {

    @Override
    public List<String> buildStopWords(String filePath) {
        try {

            List<String> stopWords = new ArrayList<>();

            // Read in file
            FileInputStream fileInputStream = new FileInputStream(filePath);
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
            String strLine;

            //Read each stop word and save it to list
            System.out.println ("Adding stop word to list...");
            while ((strLine = bufferedReader.readLine()) != null)   {
                stopWords.add(strLine);
            }

            // Print each saved stop word
            /*
            for(String string : stopWords) {
                System.out.println(string);
            }
            */

            //Close the input stream
            dataInputStream.close();
            return stopWords;

        } catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }

        return null;
    }
}
