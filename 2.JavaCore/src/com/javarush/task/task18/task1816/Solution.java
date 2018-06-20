package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) {
        String fileName;
        try {
            fileName = args[0];
            int countEngLett = 0;
            try (FileInputStream fis = new FileInputStream(fileName)) {
                while (fis.available() > 0) {
                    char charValue = (char) fis.read();
                    if (charValue > 64 && charValue < 91 ||
                            charValue > 96 && charValue < 123)
                        countEngLett++;
                }
                System.out.println(countEngLett);
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
