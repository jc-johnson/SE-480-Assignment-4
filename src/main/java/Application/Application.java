package main.java.Application;

import main.java.FileReaders.Reader;
import main.java.FileReaders.DataSink;
import main.java.Impl.Stemmer;
import main.java.Impl.WordRemover;
import main.java.Utils.Constants;

import java.util.List;

public class Application {

    public static void run(String filePath) {

        // Get stopwords
        Reader reader = new Reader();
        List<String> stopWords = reader.buildStopWords(Constants.STOP_WORDS_FILE);

        // Remove stopwords
        WordRemover wordRemover = new WordRemover(stopWords);
        wordRemover.filterFile(filePath);

        // apply stemming words
        Stemmer stemmer = new Stemmer();
        stemmer.filter(Constants.WORD_REMOVAL_OUTPUT_FILE);

        // data sink
        DataSink dataSink = new DataSink();
        dataSink.run(Constants.STEMMER_OUTPUT_FILE);
        dataSink.printTopWordCount(10);
    }
}
