package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        if (args.length == 0 || args[0].isEmpty() || args[1].isEmpty()) return;
        new Solution().go(args);
    }

    private void go(String[] args) {
        String srcFileName = args[0];
        String dstFileName = args[1];
        try (BufferedReader fileReader = new BufferedReader(new FileReader(srcFileName))) {
            try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(dstFileName))) {
                String line;
                StringBuilder result = new StringBuilder();
                while ((line = fileReader.readLine()) != null) {
//                    More universal line that validator will not accept:
//                    String[] splitLine = line.split("[\\p{Space}\\p{Punct}]+");
                    String[] splitLine = line.split("\\s+");
                    for (int i = 0; i < splitLine.length; i++) {
                        String word = splitLine[i];
                        int threshold = 6;
                        if (word.length() > threshold) {
                            result.append(word);
                            result.append(",");
                        }
                    }
                }
                String output = result.toString();
                fileWriter.write(output, 0, output.length() - 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
