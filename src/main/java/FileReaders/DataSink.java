package main.java.FileReaders;

import main.java.Interfaces.WordCounter;
import main.java.Utils.Constants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by JJOHN on 10/28/2017.
 *
 * Counts how many times a word appears in a file
 */
public class DataSink implements WordCounter {

    WordCounter wordCounter;

    public DataSink(WordCounter wordCounter) {
        this.wordCounter = wordCounter;
    }

    @Override
    public void run(String fileName, int printCount) {
        wordCounter.run(fileName, printCount);
    }

}