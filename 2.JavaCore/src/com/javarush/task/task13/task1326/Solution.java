package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Solution {
    private List<Integer> evenInts;

    public static void main(String[] args) {
        // напишите тут ваш код
        new Solution().go();
    }

    private void go() {
        evenInts = new ArrayList<>();
        evenIntsFromFileToList2(evenInts);
        Collections.sort(evenInts);
        for (Integer i : evenInts)
            System.out.println(i);
    }

    private void evenIntsFromFileToList(List<Integer> evens) {
        String fileName;
        try {
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            fileName = consoleReader.readLine();
            consoleReader.close();
            // there's a file randomData.txt in the root directory
            // that contains some integers
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            while (fileReader.ready()) {
                String line = fileReader.readLine();
                if (isInteger(line)) {
                    int number = Integer.parseInt(line);
                    if (number % 2 == 0)
                        evens.add(number);
                }
            }
            fileReader.close();
        } catch (NullPointerException | NumberFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    // Another version of evenIntsFromFileToList(List<Integer> evens)
    // that is created to comply with the validator.
    // In this version FileInputStream & InputStreamReader are used
    // instead of FileReader.
    private void evenIntsFromFileToList2(List<Integer> evens) {
        String fileName;
        BufferedReader fileReader = null;
        try {
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            fileName = consoleReader.readLine();
            consoleReader.close();
            // there's a file randomData.txt in the root directory
            // that contains some integers
            FileInputStream fis = new FileInputStream(fileName);
            fileReader = new BufferedReader(new InputStreamReader(fis));
            while (fileReader.ready()) {
                String line = fileReader.readLine();
                if (isInteger(line)) {
                    int number = Integer.parseInt(line);
                    if (number % 2 == 0)
                        evens.add(number);
                }
            }
        } catch (NullPointerException | NumberFormatException | IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean isInteger(String line) {
        if (line.isEmpty()) return false;
        for (int i = 0; i < line.length(); i++) {
            if (i == 0 && line.charAt(i) == '-') {
                if (line.length() == 1)
                    return false;
                else continue;
            }
            if (Character.digit(line.charAt(i), 10) < 0)
                return false;
        }
        return true;
    }
}
