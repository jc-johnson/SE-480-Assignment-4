package main.java.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by JJOHN on 11/1/2017.
 *
 * Writes data to file
 */
public class FileWriter {

    public File write(List<String> text, String filePath) {

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(filePath, "UTF-8");
            for (String string : text) {
                System.out.println("Writing string to file");
                writer.println(string);
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new File(filePath);
    }
}
