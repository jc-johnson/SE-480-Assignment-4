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

    public String removeWords(String wordToRemove, String string) {

        String finalWord = string.toLowerCase();
        String regex = "^" + wordToRemove + "$";
        finalWord = finalWord.replaceAll(regex, "");
        this.finalText.add(finalWord);
        System.out.println("REMOVING: " + wordToRemove + " FROM: " + string);
        System.out.println("Final text: " + finalWord);
        return finalWord;

    }

    @Override
    public List<String> filter(List<String> text) {

        if (text != null) {
            List<String> finalText = new ArrayList<>();
            String tempString = "";


            for (String string : text) {
                for(String word : words) {
                    tempString = removeWords(word, string);
                }
                finalText.add(tempString); // add string to final text after removing all unecessary words
            }

            return finalText;
        }

        return null;
    }

    /**
     * Removes all stop words present in a given file
     * @param filePath
     * @return
     */
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
                List<String> preFilteredText = new ArrayList<>();

                //Read File Line By Line and add it to list
                while ((strLine = br.readLine()) != null)   {
                    System.out.println ("Adding line to list...");
                    preFilteredText.add(strLine);
                }

                // Filters stopwords out of text
                output = this.filter(preFilteredText);

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
}
