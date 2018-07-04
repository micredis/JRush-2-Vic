package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        new Solution().go();
    }

    private void go() {
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = consoleReader.readLine();
            try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
                StringBuilder line = new StringBuilder();
                while (fileReader.ready()) {
                    line.append(fileReader.readLine());
                    System.out.println(line.reverse().toString());
                    line.setLength(0);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
