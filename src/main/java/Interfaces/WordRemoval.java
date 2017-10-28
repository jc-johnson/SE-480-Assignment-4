package main.java.Interfaces;

import java.util.List;

/**
 * Created by JJOHN on 10/28/2017.
 */
public interface WordRemoval {

    /**
     * Remove words from a piece of text
     * @param text
     * @param words
     * @return
     */
    List<String> removeWords(List<String> text, List<String> words);
}
