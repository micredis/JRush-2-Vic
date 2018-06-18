package com.javarush.task.task18.task1803;

import java.io.FileInputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // there is a file in the current package
        // /home/lab511a/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1803/source.txt
        // for the test purposes
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();
        FileInputStream fis = new FileInputStream(fileName);
        Map<Integer, Long> byteTable = new HashMap<>();
        while (fis.available() > 0) {
            int byteKey = fis.read();
            if (!byteTable.containsKey(byteKey)) {
                byteTable.put(byteKey, 1L);
            } else {
                byteTable.put(byteKey, byteTable.get(byteKey) + 1);
            }
        }
        fis.close();
        long maxOccurences = Collections.max(byteTable.values());
        StringBuilder sb = new StringBuilder();
        for (Integer byteKey : byteTable.keySet()) {
            if (byteTable.get(byteKey) == maxOccurences) {
                sb.append(byteKey);
                sb.append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
