package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    private static final String DELIMITER = "[\\p{Space}\\p{Punct}]";
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        // /home/micredis/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1922/file.txt
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = consoleReader.readLine();
            try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = fileReader.readLine()) != null) {
                    String[] lineSplit = line.split(DELIMITER);
                    int matches = 0;
                    for (String word : lineSplit) {
                        if (words.contains(word))
                            matches++;
                    }
                    if (matches == 2)
                        System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
