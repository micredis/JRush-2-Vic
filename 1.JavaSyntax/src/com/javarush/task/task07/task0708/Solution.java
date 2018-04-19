package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/* 
Самая длинная строка
*/

public class Solution {
    private static List<String> strings;

    public static void main(String[] args) {
        //напишите тут ваш код
        new Solution().go();
    }

    private void go() {
        strings = new ArrayList<String>();
        readLinesToList(5);
        printLongestStringsFromList();
    }

    private void readLinesToList(int numberOfLines) {
        try {
            Reader reader = new InputStreamReader(System.in);
            BufferedReader bufReader = new BufferedReader(reader);
            for (int i = 0; i < numberOfLines; i++) {
                strings.add(bufReader.readLine());
            }
            bufReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printLongestStringsFromList() {
        int maxLen = 0;
        for (String s : strings) {
            if (s.length() > maxLen)
                maxLen = s.length();
        }
        for (String s : strings) {
            if (s.length() == maxLen)
                System.out.println(s);
        }
    }
}
