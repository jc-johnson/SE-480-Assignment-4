package main.java.Application;

import main.java.FileReaders.Reader;
import main.java.FileReaders.RepeatedWordsInFile;
import main.java.Impl.Stemmer;
import main.java.Impl.WordRemoval;

import java.util.List;

public class Application {

    public static void run() {

        Reader reader = new Reader();
        List<String> stopWords = reader.buildStopWords();

        // remove stopwords
        WordRemoval wordRemoval = new WordRemoval(stopWords);
        // List<String> text = wordRemoval.filter(/*file name*/);
        // TODO: save text as a file to use for stemmer

        // apply stemming words
        Stemmer stemmer = new Stemmer();
        // porterStemmer.run();

        // data sink
        // Filter dataSink = new RepeatedWordsInFile();
        RepeatedWordsInFile repeatedWordsInFile = new RepeatedWordsInFile(/*file name*/);
        // repeatedWordsInFile.run();
    }



}
