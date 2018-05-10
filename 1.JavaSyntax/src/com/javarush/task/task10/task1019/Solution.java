package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        readInputToMap(map);
        printMap(map);
    }

    private static void readInputToMap(HashMap<String, Integer> map) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String sId = reader.readLine();
                if (sId.isEmpty())
                    break;
                int id = Integer.parseInt(sId);
                String name = reader.readLine();
                if (name.isEmpty()) {
                    System.out.println(id);
                    break;
                }
                map.put(name, id);
            }
            reader.close();
        } catch (Exception ignored) {
        }
    }

    private static void printMap(HashMap<String, Integer> map) {
        for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
            String sId = String.valueOf(entry.getValue());
            String name = entry.getKey();
            System.out.println(sId + " " + name);
        }
    }
}
