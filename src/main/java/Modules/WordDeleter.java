package main.java.Modules;

import main.java.Utils.Constants;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WordDeleter {

    public void deleteWords(String text, List<String> wordsToDelete) {

        List<String> words = wordsToDelete;
        String oldText = text;

        String word = words.get(0);
        String regex = "[^a-zA-Z0-9]" + word + "[^a-zA-Z0-9]";
        String replacedText  = oldText.replaceAll(regex, " ");


        for (int i = 1; i < words.size(); i++) {
            regex = "[^a-zA-Z0-9]" + words.get(i) + "[^a-zA-Z0-9]" ;
            replacedText = replacedText.replaceAll(regex, " ");
        }

        // Overwrite old file
        try {
            FileWriter writer = null;
            writer = new FileWriter(Constants.WORD_REMOVAL_OUTPUT_FILE);
            writer.write(replacedText);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
