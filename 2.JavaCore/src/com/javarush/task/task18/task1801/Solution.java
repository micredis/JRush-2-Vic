package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName = console.readLine();
        FileInputStream fis = new FileInputStream(fileName);
        int maxByte = Integer.MIN_VALUE;
        while (fis.available() > 0) {
            int value = fis.read();
            if (value > maxByte) {
                maxByte = value;
            }
        }
        System.out.println(maxByte);
        fis.close();
    }
}
