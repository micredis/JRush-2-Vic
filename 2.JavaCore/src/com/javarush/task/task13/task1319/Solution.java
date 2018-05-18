package com.javarush.task.task13.task1319;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Писатель в файл с консоли
*/

public class Solution {
    private static final String EXIT = "exit";

    public static void main(String[] args) {
        // напишите тут ваш код
        new Solution().go();
    }

    private void go() {
        String fileName = "";
        String line = "";
        try {
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            fileName = consoleReader.readLine();
            // create a file in the root of the project
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName));
            do {
                line = consoleReader.readLine();
                fileWriter.write(String.format("%s%n", line));
            } while (!EXIT.equals(line));
            fileWriter.close();
            consoleReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
