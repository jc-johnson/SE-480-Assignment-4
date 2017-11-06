package main.java.Impl;

import main.java.Interfaces.WordFilter;
import main.java.Modules.FileParser;
import main.java.Modules.WordDeleter;

import java.util.List;

public class WordFilterImpl implements WordFilter {
    @Override
    public String filter(String filePath, List<String> wordList) {

        List<String> words = wordList;

        try
        {
            /*
            File file = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = "";
            String oldtext = "";

            // Copy file to string
            while((line = reader.readLine()) != null)
            {
                oldtext += line.toLowerCase() + "\r\n";   // create new line
            }
            reader.close();
            */


            // Modularizing above logic
            FileParser fileParser = new FileParser();
            String oldText = fileParser.parse(filePath);

            // Passing old text string

            // Modularizing following logic
            WordDeleter wordDeleter = new WordDeleter();
            return wordDeleter.deleteWords(oldText, words);

            /*
            String word = words.get(0);
            String regex = "[^a-zA-Z0-9]" + word + "[^a-zA-Z0-9]";
            String replacedText  = oldtext.replaceAll(regex, " ");

            for (int i = 1; i < words.size(); i++) {
                regex = "[^a-zA-Z0-9]" + words.get(i) + "[^a-zA-Z0-9]" ;
                replacedText = replacedText.replaceAll(regex, " ");
            }

            // Overwrite old file
            FileWriter writer = new FileWriter(Constants.WORD_REMOVAL_OUTPUT_FILE);
            writer.write(replacedText);
            writer.close();
            */
        }  catch (Exception e) {

        }
        // catch (IOException ioe)
        //  {
        //      ioe.printStackTrace();
        //  }
        return "";
    }
}
