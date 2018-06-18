package com.javarush.task.task18.task1804;

import java.io.FileInputStream;
import java.util.Collections;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();
        FileInputStream fis = new FileInputStream(fileName);
        Map<Integer, Long> byteMap = new HashMap<>();
        while (fis.available() > 0) {
            int byteKey = fis.read();
            if (!byteMap.containsKey(byteKey)) {
                byteMap.put(byteKey, 0L);
            } else {
                byteMap.put(byteKey, byteMap.get(byteKey) + 1);
            }
        }
        fis.close();
        long minOccurences = Collections.min(byteMap.values());
        StringBuilder sb = new StringBuilder();
        for (Integer byteKey : byteMap.keySet()) {
            if (byteMap.get(byteKey) == minOccurences) {
                sb.append(byteKey);
                sb.append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
