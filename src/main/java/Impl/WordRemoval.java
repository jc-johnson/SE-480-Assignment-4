package main.java.Impl;

import main.java.Interfaces.Filter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JJOHN on 10/28/2017.
 */
public class WordRemoval implements Filter{

    List<String> words;
    List<String> finalText = new ArrayList<>();

    public WordRemoval() {

    }

    public WordRemoval(List<String> words) {
        this.words = words;
    }

    public String removeWords(String string, String removeWord) {

        String finalWord = string.toLowerCase();
        finalWord = finalWord.replaceAll(removeWord, "");
        this.finalText.add(finalWord);
        System.out.println("REMOVING: " + removeWord + " FROM: " + string);
        return finalWord;


    }

    public static void main(String[] args) {
        String[] words = {"the", "and", "or"};
        String sentence = "The cat jumped over the hat and the dog or the moose";
        List<String> wordList = new ArrayList<String>();

        for(String string : words) {
            wordList.add(string);
        }

        // System.out.println(removeWords(sentence, "the"));
        WordRemoval wordRemoval = new WordRemoval();

        for(String string : wordList) {
            String newSentence = wordRemoval.removeWords(sentence, string);
            System.out.println("New sentence: " + newSentence);
        }
    }

    @Override
    public List<String> filter(List<String> text) {

        if (text != null) {
            List<String> finalText = new ArrayList<>();
            String tempString;


            for (String string : text) {
                for(String word : words) {
                    tempString = removeWords(word, string);
                    finalText.add(tempString);
                }
            }

            return finalText;
        }

        return null;
    }

    @Override
    public List<String> filter(String filePath) {
        List<String> output = new ArrayList<>();

        if (filePath != "") {
            try {
                // Open the file
                FileInputStream fstream = null;
                fstream = new FileInputStream(filePath);
                BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

                String strLine;

                //Read File Line By Line
                while ((strLine = br.readLine()) != null)   {
                    // Print the content on the console
                    System.out.println (strLine);
                    // Add content to file
                    output.add(strLine);
                }

                //Close the input stream
                br.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return output;

    }
}
