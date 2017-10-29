package main.java.Application;

import main.java.FileReaders.RepeatedWordsInFile;
import main.java.Impl.PorterStemmerImpl;
import main.java.Impl.WordRemovalImpl;
import main.java.Interfaces.WordRemoval;

public class Application {

    public static void run() {
        // read in text files

        // remove stopwords
        // Filter wordRemoval = new WordRemovalImpl();
        WordRemoval wordRemoval = new WordRemovalImpl();
        // wordRemoval.run();

        // apply stemming words
        // Filter porterStemmer = new PorterStemmerImpl();
        PorterStemmerImpl porterStemmer = new PorterStemmerImpl();
        // porterStemmer.run();

        // data sink
        // Filter dataSink = new RepeatedWordsInFile();
        RepeatedWordsInFile repeatedWordsInFile = new RepeatedWordsInFile();
        // repeatedWordsInFile.run();
    }



}
