package com.javarush.task.task18.task1802;

import java.io.FileInputStream;
import java.util.Scanner;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();
        FileInputStream fis = new FileInputStream(fileName);
        int minByte = Integer.MAX_VALUE;
        while (fis.available() > 0) {
            int value = fis.read();
            if (value < minByte)
                minByte = value;
        }
        System.out.println(minByte);
        fis.close();
    }
}
