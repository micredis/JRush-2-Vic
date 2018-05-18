package com.javarush.task.task13.task1318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        new Solution().go();
    }

    private void go() {
        // there's a randomData.txt in the root directory
        String fileName = readConsole();
        printFile(fileName);
    }

    private String readConsole() {
        String line = "";
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            line = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    private void printFile(String fileName) {
        try {
            FileInputStream inputStream = new FileInputStream(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader fileReader = new BufferedReader(inputStreamReader);
            while (fileReader.ready()) {
                System.out.println(fileReader.readLine());
            }
            fileReader.close();
            // validator desperately needs these streams to be closed as well
            inputStreamReader.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}