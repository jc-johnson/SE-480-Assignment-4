package main.java.Application;

import main.java.FileReaders.Reader;
import main.java.FileReaders.RepeatedWordsInFile;
import main.java.Impl.Stemmer;
import main.java.Impl.WordRemoval;
import main.java.Utils.Constants;
import main.java.Utils.FileWriter;

import java.io.File;
import java.util.List;

public class Application {

    public static void run(String filePath) {

        // Get stopwords
        Reader reader = new Reader();
        List<String> stopWords = reader.buildStopWords(Constants.STOP_WORDS_FILE);

        // Remove stopwords
        WordRemoval wordRemoval = new WordRemoval(stopWords);
        List<String> text = wordRemoval.filter(filePath);

        // Save wordRemoval output as a file to use for stemmer
        FileWriter fileWriter = new FileWriter();
        fileWriter.write(text);

        // apply stemming words
        Stemmer stemmer = new Stemmer();
        stemmer.filter(Constants.OUTPUT_FILE);

        // data sink
        // Filter dataSink = new RepeatedWordsInFile();
        RepeatedWordsInFile repeatedWordsInFile = new RepeatedWordsInFile(/*file name*/);
        // repeatedWordsInFile.run();
    }



}
