package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        if (args.length == 0) return;
        new Solution().go(args);
    }

    private void go(String[] args) {
        String tag = args[0];
        String line = fileToLine();
        printAllTags(tag, line, 0);
    }

    private String fileToLine() {
        StringBuilder result = new StringBuilder();
        try (
                BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader fileReader = new BufferedReader(new FileReader(console.readLine()))
        ) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                result.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString().replaceAll("[\\r\\n]+", "");
    }

    private void printAllTags(String tag, String stringToSearch, int offset) {
        int tagCount = 0, leftPosition = 0;
        for (int i = offset; i < stringToSearch.length() - tag.length() - 1; i++) {
            String sub = stringToSearch.substring(i);
            if (sub.matches("<" + tag + ".*>.*")) {
                if (tagCount == 0)
                    leftPosition = i;
                tagCount++;
            } else if (sub.matches("</" + tag + ">.*") && tagCount > 0) {
                tagCount--;
                if (tagCount == 0) {
                    System.out.println(stringToSearch.substring(leftPosition, i + tag.length() + 3));
                    printAllTags(tag, stringToSearch.substring(leftPosition + tag.length(), i), 1);
                }
            }
        }
    }
}
