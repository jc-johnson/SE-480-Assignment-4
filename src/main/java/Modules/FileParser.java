package main.java.Modules;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileParser {

    public String parse(String filePath) {
        String oldtext = "";
        try {
            File file = new File(filePath);
            BufferedReader reader = null;
            reader = new BufferedReader(new java.io.FileReader(file));
            String line = "";

            // Copy file to string
            while((line = reader.readLine()) != null)
            {
                oldtext += line.toLowerCase() + "\r\n";   // create new line
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return oldtext;
    }
}
