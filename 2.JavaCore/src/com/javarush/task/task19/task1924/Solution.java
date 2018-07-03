package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    private static final String UP_TO_DOZEN = "([1]?[0-2])|[0-9]?";
    private static final String SPACE = "\\s+";
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) {
        new Solution().go();
    }

    private void go() {
        String srcFileName = readFileName();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(srcFileName))) {
            String line;
            while((line = fileReader.readLine()) != null) {
                StringBuilder modifiedLine = new StringBuilder();
                String[] splitLine = line.split(SPACE);
                for (String word : splitLine) {
                    if (word.matches(UP_TO_DOZEN)) {
                        int number = Integer.parseInt(word);
                        word = map.get(number);
                    }
                    modifiedLine.append(word);
                    modifiedLine.append(" ");
                }
                System.out.println(modifiedLine.toString().trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readFileName() {
        String fileName = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }
}
