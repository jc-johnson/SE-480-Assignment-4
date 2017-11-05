package main.java.FileReaders;

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
public class DataSink {

    //Creating wordCountMap which holds words as keys and their occurrences as values
    List<Map.Entry<String, Integer>> topWordCount = new ArrayList<Map.Entry<String,Integer>>();
    HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>();
    BufferedReader reader = null;

    public void run(String fileName) {
        try {

            // Parsing file
            reader = new BufferedReader(new FileReader(fileName));
            String currentLine = reader.readLine();

            while (currentLine != null) {
                //splitting the currentLine into words
                String[] words = currentLine.toLowerCase().split(" ");

                for (String word : words) {
                    //if word is already present in wordCountMap, updating its count
                    if(wordCountMap.containsKey(word)) {
                        wordCountMap.put(word, wordCountMap.get(word)+1);
                    } else {  //otherwise inserting the word as key and 1 as its value
                        wordCountMap.put(word, 1);
                    }
                }

                //Reading next line into currentLine
                currentLine = reader.readLine();
            }

            //Getting all the entries of wordCountMap in the form of Set
            Set<Map.Entry<String, Integer>> entrySet = wordCountMap.entrySet();

            //Creating a List by passing the entrySet
            List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String,Integer>>(entrySet);

            //Sorting the list in the decreasing order of values
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2)
                {
                    return (e2.getValue().compareTo(e1.getValue()));
                }
            });

            //Printing the repeated words in input file along with their occurrences
            // System.out.println("Repeated Words In Input File Are :");

            // Keep track of
            for (Map.Entry<String, Integer> entry : list) {
                if (entry.getValue() > 1) {
                    // System.out.println(entry.getKey() + " : "+ entry.getValue());
                    topWordCount.add(entry);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void checkStopWords(List<String> stopwords) {

    }

    /**
     * Gets x top used words
     * @param count
     */
    public void printTopWordCount(int count) {
        System.out.println("Top " + count + " words in file:");
        for (int i = 0; i < count; i++) {
            System.out.println(topWordCount.get(i).getKey() + " " + topWordCount.get(i).getValue());
        }
    }

    public static void main(String[] args) {
        DataSink dataSink = new DataSink();
        dataSink.run(Constants.ALICE_FILE);
    }
}