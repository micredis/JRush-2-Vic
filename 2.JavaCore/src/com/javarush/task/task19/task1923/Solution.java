package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    private static final String DELIMITER = "\\s+";
    private static final String ALPHANUMERIC = ".*\\d+.*";

    public static void main(String[] args) {
        if (args.length < 2 || args[0].isEmpty() || args[1].isEmpty()) return;
        Solution solution = new Solution();
        String srcFileName = args[0];
        String dstFileName = args[1];
        try (BufferedReader fileReader = new BufferedReader(new FileReader(srcFileName))) {
            try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(dstFileName))) {
                StringBuilder alphanumerics = new StringBuilder();
                String line;
                while ((line = fileReader.readLine()) != null) {
                    String[] splitLine = line.split(DELIMITER);
                    for (String word : splitLine) {
                        // a number is also considered as a "word that contains a number"
                        if (word.matches(ALPHANUMERIC)) {
                            alphanumerics.append(word);
                            alphanumerics.append(" ");
                        }
                    }
                }
                fileWriter.write(alphanumerics.toString().trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
