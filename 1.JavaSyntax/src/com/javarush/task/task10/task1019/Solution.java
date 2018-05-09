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
        int id;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String sId = reader.readLine();
            String name = reader.readLine();
            while (true) {
                if (!name.isEmpty() && !sId.isEmpty()) {
                    id = Integer.parseInt(sId);
                    map.put(name, id);
                    sId = reader.readLine();
                    name = reader.readLine();
                } else if (name.isEmpty()) {
                    id = Integer.parseInt(sId);
                    map.put(name, id);
                    break;
                } else {
                    map.put(name, null);
                    break;
                }
            }
            reader.close();
        } catch (IOException | NumberFormatException ignored) {
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
