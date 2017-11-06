package main.java.Impl;

import main.java.Interfaces.WordFilter;
import main.java.Modules.FileParser;
import main.java.Modules.WordDeleter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JJOHN on 10/28/2017.
 */
public class WordRemover implements WordFilter{

    List<String> words;
    WordFilter wordFilter;

    public WordRemover(WordFilter wordFilter, List<String> words ) {
        this.wordFilter = wordFilter;
        this.words = words;
    }

    /**
     * Removes all stop words present in a given file
     * @param filePath
     * @return
     */
    public String filter (String filePath, List<String> wordList) {
        return wordFilter.filter(filePath, wordList);
    }
}
