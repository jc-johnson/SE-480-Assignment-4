package main.java.Interfaces;

import java.util.List;

/**
 * Performs filtering operations on variety of different inputs
 */
public interface Filter {

    List<String> filter(List<String> text);

    List<String> filter(String filePath);

}
