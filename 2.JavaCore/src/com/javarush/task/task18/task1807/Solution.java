package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    private static final char COMMA = ',';

    public static void main(String[] args) {
        new Solution().go();
    }

    private void go() {
        String fileName = readFileName();
        int commaCount = 0;
        try (FileInputStream fis = new FileInputStream(fileName)) {
            while (fis.available() > 0) {
                int byteValue = fis.read();
                if ((char) byteValue == COMMA)
                    commaCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(commaCount);
    }

    private String readFileName() {
        String fileName = "";
        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNext()) {
                fileName = scanner.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;
    }
}
