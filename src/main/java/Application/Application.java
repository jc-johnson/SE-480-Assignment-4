package main.java.Application;

import main.java.FileReaders.Reader;
import main.java.FileReaders.DataSink;
import main.java.Impl.BuildableImpl;
import main.java.Impl.Stemmer;
import main.java.Impl.WordRemover;
import main.java.Interfaces.Buildable;
import main.java.Utils.Constants;

import java.util.List;

public class Application {

    public static void run(String filePath) {

        // Get stop-words
        // Reader reader = new Reader();
        Buildable buildable = new Reader(new BuildableImpl());
        List<String> stopWords = buildable.buildStopWords(Constants.STOP_WORDS_FILE);

        long startTime = System.currentTimeMillis();

        // Remove stop-words
        WordRemover wordRemover = new WordRemover(stopWords);
        wordRemover.filterFile(filePath);

        // Apply stemming algorithm
        Stemmer stemmer = new Stemmer();
        stemmer.filter(Constants.WORD_REMOVAL_OUTPUT_FILE);

        // Get most commonly used words
        DataSink dataSink = new DataSink();
        dataSink.run(Constants.STEMMER_OUTPUT_FILE);
        dataSink.printTopWordCount(10);

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Duration: " + duration);
    }
}
