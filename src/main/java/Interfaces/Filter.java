package main.java.Interfaces;

import java.util.List;

public interface Filter {

    public List<String> filter(List<String> text);

    public List<String> filter(String filePath);

}
