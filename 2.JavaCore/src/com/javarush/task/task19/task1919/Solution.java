package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    private final String SPACE = "\\s+";

    public static void main(String[] args) {
        new Solution().go(args);
    }

    private void go(String[] args) {
        if (args.length == 0 || args[0].isEmpty()) return;
        Map<String, Double> salaries = readFileToMap(args[0]);
        for (String name : salaries.keySet()) {
            System.out.println(name + " " + salaries.get(name));
        }
    }

    private Map<String, Double> readFileToMap(String fileName) {
        Map<String, Double> map = new TreeMap<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            String[] line;
            while (fileReader.ready()) {
                line = fileReader.readLine().split(SPACE);
                if (line.length > 1) {
                    String name = line[0];
                    double salary = Double.parseDouble(line[1]);
                    if (!map.containsKey(name)) {
                        map.put(name, salary);
                    } else {
                        map.put(name, map.get(name) + salary);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
