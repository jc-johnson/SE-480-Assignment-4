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

        long totalStartTime = System.currentTimeMillis();

        // Remove stop-words
        WordRemover wordRemover = new WordRemover(stopWords);
        long wordRemoverStartTime = System.currentTimeMillis();
        wordRemover.filterFile(filePath);
        long wordRemoverEndTime = System.currentTimeMillis();
        long totalWordRemoverDuration = wordRemoverEndTime - wordRemoverStartTime;

        // Apply stemming algorithm
        Stemmer stemmer = new Stemmer();
        long stemmerFilterStartTime = System.currentTimeMillis();
        stemmer.filter(Constants.WORD_REMOVAL_OUTPUT_FILE);
        long stemmerFilterEndTime = System.currentTimeMillis();
        long totalStemmerFilterDuration = stemmerFilterEndTime - stemmerFilterStartTime;

        // Get most commonly used words
        DataSink dataSink = new DataSink();
        long dataSinkStartTime = System.currentTimeMillis();
        dataSink.run(Constants.STEMMER_OUTPUT_FILE);
        long dataSinkEndTime = System.currentTimeMillis();
        long totalDataSinkDuration = dataSinkEndTime - dataSinkStartTime;
        dataSink.printTopWordCount(10);

        long totalEndTime = System.currentTimeMillis();
        long totalDuration = totalEndTime - totalStartTime;
        System.out.println("Total duration: " + totalDuration);
        System.out.println("Total duration for word remover filter: " + totalWordRemoverDuration);
        System.out.println("Total duration for stemmer filter: " + totalStemmerFilterDuration);
        System.out.println("Total duration for data sink filter: " + totalDataSinkDuration );
    }
}
