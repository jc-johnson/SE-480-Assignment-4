package main.java.Impl;

import main.java.Interfaces.StemmerFilter;
import main.java.Utils.Constants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StemmerFilterImpl implements StemmerFilter {
    @Override
    public String filter(String filePath) {
        char[] w = new char[501];
        Stemmer s = new Stemmer(new StemmerFilterImpl());
        List<String> output = new ArrayList<>();

        try {
            // FileInputStream in = new FileInputStream(args[i]);
            FileInputStream in = new FileInputStream(filePath);

            try {
                while(true) {
                    // start reading in characters
                    int ch = in.read();
                    if (Character.isLetter((char) ch)) {
                        int j = 0;
                        while(true) {

                            // keep reading in characters
                            ch = Character.toLowerCase((char) ch);
                            w[j] = (char) ch;
                            if (j < 500) j++;
                            ch = in.read();
                            if (!Character.isLetter((char) ch)) {

                                // to test add(char ch)
                                for (int c = 0; c < j; c++) s.add(w[c]);

                                // or, to test add(char[] w, int j)
                                    /* s.add(w, j); */

                                s.stem();
                                {  String u;

                                        /* and now, to test toString() : */
                                    u = s.toString()+"\r\n";

                                        /* to test getResultBuffer(), getResultLength() : */
                                        /* u = new String(s.getResultBuffer(), 0, s.getResultLength()); */
                                    // System.out.print(u);
                                    // save output
                                    output.add(u);
                                }

                                break;
                            }
                        }
                    }
                    if (ch < 0) break;  // not a character
                    char character = (char) ch;
                    // System.out.print(character);
                    // output.add((String)character);
                }
            } catch (IOException e) {
                System.out.println("error reading " + filePath);
            }
        } catch (FileNotFoundException e) {
            System.out.println("file " + filePath + " not found");
        } finally {
            // Write output to file
            FileWriter writer;
            try {
                writer = new FileWriter(Constants.STEMMER_OUTPUT_FILE);
                for (String string : output) {
                    writer.write(string);
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return Constants.STEMMER_OUTPUT_FILE;
    }
}
