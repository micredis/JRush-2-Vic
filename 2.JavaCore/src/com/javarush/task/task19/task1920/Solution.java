package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        if (args.length == 0 || args[0].isEmpty()) return;
        new Solution().go(args);
    }

    private void go(String[] args) {
        Map<String, Double> salaries = readFileToMap(args[0]);
        List<String> topPaidNames = getTopNames(salaries, getMaxValue(salaries));
        Collections.sort(topPaidNames);
        for (String name : topPaidNames) {
            System.out.println(name);
        }
    }

    private Map<String, Double> readFileToMap(String fileName) {
        Map<String, Double> map = new HashMap<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            String[] lineSplit;
            while ((line = fileReader.readLine()) != null) {
                lineSplit = line.split("\\s+");
                String name = lineSplit[0];
                double salary = Double.parseDouble(lineSplit[1]);
                if (map.containsKey(name))
                    map.put(name, map.get(name) + salary);
                else
                    map.put(name, salary);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    private double getMaxValue(Map<String, Double> salaries) {
        return Collections.max(salaries.values());
    }

    private List<String> getTopNames(Map<String, Double> employees, double maxSalary) {
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Double> employee : employees.entrySet()) {
            double salary = employee.getValue();
            if (salary == maxSalary) {
                String name = employee.getKey();
                list.add(name);
            }
        }
        return list;
    }
}
