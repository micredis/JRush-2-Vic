package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        if (args.length == 0) return;
        String fileName = args[0];
        System.out.format("%.2f%n", getSpaceRatio(fileName, 2));
    }

    private static double getSpaceRatio(String fileName, int precision) {
        int symbolCount = 0;
        int spaceCount = 0;
        try (FileInputStream fis = new FileInputStream(fileName)) {
            while (fis.available() > 0) {
                char symbol = (char) fis.read();
                if (symbol == ' ')
                    spaceCount++;
                symbolCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (symbolCount == 0)
            return 0.0;
        double roundBase = Math.pow(10, precision);
        return (double) (Math.round(1.0 * spaceCount / symbolCount * roundBase)) / roundBase;
    }
}
