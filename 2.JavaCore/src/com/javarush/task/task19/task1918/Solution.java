package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        if (args.length == 0) return;
        new Solution().go(args);
    }

    private void go(String[] args) {
        String tag = args[0];
        String line = fileToLine();
        printAllTags(tag, line);
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
        return result.toString().replaceAll("[\\s\\r\\n]+", " ");
    }

    private void printAllTags(String tag, String stringToSearch) {
        Pattern pattern = Pattern.compile("<" + tag + "(.+)>(\\S+)</" + tag + ">");
        Matcher matcher = pattern.matcher(stringToSearch);
        while (matcher.find()) {
            String group = matcher.group(1);
            System.out.println(group);
        }
    }
}
