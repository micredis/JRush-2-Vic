package com.javarush.task.task18.task1823;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 
Нити и байты
*/

public class Solution {
    private static final String EXIT = "exit";
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // /home/micredis/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1823/file1.txt
        // /home/micredis/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1823/file2.txt
        // /home/micredis/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1823/file3.txt
        String fileName;
        while (scanner.hasNext() && !EXIT.equals(fileName = scanner.nextLine())) {
            new ReadThread(fileName).start();
        }
        scanner.close();
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
//            int aByte = entry.getValue();
//            char charValue = (char) aByte;
//            System.out.println(entry.getKey() + " " + charValue);
//        }
    }

    public static class ReadThread extends Thread {
        private String fileName;
        private Map<Integer, Integer> byteFrequencies = new HashMap<>();

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try (FileInputStream fis = new FileInputStream(fileName)) {
                while (fis.available() > 0) {
                    int aByte = fis.read();
                    if (!byteFrequencies.containsKey(aByte)) {
                        byteFrequencies.put(aByte, 1);
                    } else {
                        byteFrequencies.put(aByte, byteFrequencies.get(aByte) + 1);
                    }
                }
                int maxCount = 0;
                int maxByte = -1;
                for (Map.Entry<Integer, Integer> entry : byteFrequencies.entrySet()) {
                    int count = entry.getValue();
                    if (count > maxCount) {
                        maxCount = count;
                        maxByte = entry.getKey();
                    }
                }
                resultMap.put(fileName, maxByte);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
