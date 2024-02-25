package ru.nsu.ccfit.Popov;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> wordFriquecyMap = new HashMap<>();
        StringBuilder builder = new StringBuilder();

        //String currentWord;

        try (FileReader rider = new FileReader("inputFile.txt")){
            while (rider.ready()){
                char currentSymbol = (char) rider.read();
                if (Character.isLetterOrDigit(currentSymbol))
                    builder.append(currentSymbol);
                else if (!builder.isEmpty()){
                    String currentWord = builder.toString();
                    wordFriquecyMap.put(currentWord, wordFriquecyMap.getOrDefault(currentWord, 0) + 1);
                    builder.delete(0, builder.length());
                }
            }
            if (!builder.isEmpty()) {
                String currentWord = builder.toString();
                wordFriquecyMap.put(currentWord, wordFriquecyMap.getOrDefault(currentWord, 0) + 1);
                builder.delete(0, builder.length());
            }
        }
        catch (IOException ex){
            System.err.println(ex.getMessage());
        }
    }
}