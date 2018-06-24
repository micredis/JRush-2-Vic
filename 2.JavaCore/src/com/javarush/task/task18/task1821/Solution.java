package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        if (args.length == 0) return;
        // /home/micredis/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1821/alice.txt
        String fileName = args[0];
        try (FileInputStream fis = new FileInputStream(fileName)) {
            Map<Character, Integer> charStats = new TreeMap<>();
            while (fis.available() > 0) {
                char charValue = (char) fis.read();
                if (!charStats.containsKey(charValue)) {
                    charStats.put(charValue, 1);
                } else {
                    charStats.put(charValue, charStats.get(charValue) + 1);
                }
            }
            for (Map.Entry<Character, Integer> entry : charStats.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
