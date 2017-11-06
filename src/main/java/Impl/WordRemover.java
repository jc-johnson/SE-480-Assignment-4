package main.java.Impl;

import main.java.Interfaces.Filter;
import main.java.Utils.Constants;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JJOHN on 10/28/2017.
 */
public class WordRemover implements Filter{

    List<String> words;
    List<String> finalText = new ArrayList<>();

    public WordRemover() {

    }

    public WordRemover(List<String> words) {
        this.words = words;
    }

    public String removeWords(String wordToRemove, String string) {

        // create regex for single character words
        if (wordToRemove.length() == 1) {
            String finalWord = string.toLowerCase();
            String regex = "\\b[" + wordToRemove + "]\\b";
            finalWord = finalWord.replaceAll(regex, "");
            // finalWord = finalWord.replaceAll(wordToRemove, "");
            this.finalText.add(finalWord);
            // System.out.println("REMOVING: " + wordToRemove + " FROM: " + string);
            // System.out.println("Final text: " + finalWord);
            return finalWord;
        }

        String finalWord = string.toLowerCase();
        String regex = " " + wordToRemove + " ";
        finalWord = finalWord.replaceAll(regex, "");
        // finalWord = finalWord.replaceAll(wordToRemove, "");
        this.finalText.add(finalWord);
        // System.out.println("REMOVING: " + wordToRemove + " FROM: " + string);
        // System.out.println("Final text: " + finalWord);
        return finalWord;

    }

    @Override
    public List<String> filter(List<String> text) {

        if (text != null) {
            List<String> finalText = new ArrayList<>();
            String tempString = "";
            String newTempString = "";

            for (String string : text) {
                for(String word : words) {
                    tempString = removeWords(word, string);     // gives you different string each time

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
        return null;
    }

    public void filterFile (String filePath) {
        try
        {
            File file = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = "";
            String oldtext = "";

            // Copy file to string
            while((line = reader.readLine()) != null)
            {
                oldtext += line.toLowerCase() + "\r\n";   // create new line
            }
            reader.close();

            String word = words.get(0);
            String regex = "[^a-zA-Z0-9]" + word + "[^a-zA-Z0-9]";
            String replacedText  = oldtext.replaceAll(regex, " ");

            for (int i = 1; i < words.size(); i++) {
                regex = "[^a-zA-Z0-9]" + words.get(i) + "[^a-zA-Z0-9]" ;
                replacedText = replacedText.replaceAll(regex, " ");
            }

            // Overwrite old file
            FileWriter writer = new FileWriter(Constants.WORD_REMOVAL_OUTPUT_FILE);
            writer.write(replacedText);
            writer.close();

        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String[] words = {"a", "the", "and", "or"};
        String sentence = "The cat jumped over the hat and the dog or the moose a";
        List<String> wordList = new ArrayList<String>();

        for(String string : words) {
            wordList.add(string);
        }

        // System.out.println(removeWords(sentence, "the"));
        WordRemover wordRemover = new WordRemover();

        for(String string : wordList) {
            String newSentence = wordRemover.removeWords(string, sentence);
            System.out.println("New sentence: " + newSentence);
        }
    }
}
