package main.java.Impl;

import main.java.Interfaces.WordRemoval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JJOHN on 10/28/2017.
 */
public class WordRemovalImpl implements WordRemoval {

    List<String> words;
    List<String> finalText = new ArrayList<>();

    public WordRemovalImpl() {

    }

    public WordRemovalImpl(List<String> words) {
        this.words = words;
    }

    @Override
    public List<String> removeWords(List<String> text, List<String> words) {

        List<String> localText = text;

        for(String string : localText) {
            for(String word : words) {
                removeWords(word, string);
            }
        }

        return localText;
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
        WordRemovalImpl wordRemoval = new WordRemovalImpl();

        for(String string : wordList) {
            String newSentence = wordRemoval.removeWords(sentence, string);
            System.out.println("New sentence: " + newSentence);
        }
    }
}
