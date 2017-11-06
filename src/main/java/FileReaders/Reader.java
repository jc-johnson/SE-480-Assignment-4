package main.java.FileReaders;

import main.java.Interfaces.Buildable;
import main.java.Utils.Constants;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Reader implements Buildable {

    private Buildable buildable;

    public Reader(Buildable buildable) {
        this.buildable = buildable;
    }

    @Override
    public List<String> buildStopWords(String filePath) {

        return this.buildable.buildStopWords(filePath);

    }
}
