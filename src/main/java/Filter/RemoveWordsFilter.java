package main.java.Filter;

import main.java.Interfaces.Filter;

import java.util.List;
import java.util.Scanner;

public class RemoveWordsFilter implements Filter {


    List<String> dictionary;

    public RemoveWordsFilter() {

    }


    @Override
    public List<String> filter(List<String> text) {
        return null;
    }

    @Override
    public List<String> filter(String filePath) {
        return null;
    }

    public static void main(String args[])
    {
        String strOrig, word;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a String : ");
        strOrig = scan.nextLine();

        System.out.print("Enter a Word to be Delete from the String : ");
        word = scan.nextLine();

        System.out.print("Deleting all '" + word + "' from '" + strOrig + "'...\n");
        strOrig = strOrig.replaceAll(word, "");

        System.out.print("Specified word deleted Successfully from the String..!!");

        System.out.print("\nNow the String is :\n");
        System.out.print(strOrig);
    }
}
