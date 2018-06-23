package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName1 = scanner.nextLine();
        String fileName2 = scanner.nextLine();
        scanner.close();

        try {
            // /home/lab511a/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1820/floats.txt
            // /home/lab511a/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1820/ints.txt
            FileInputStream fis = new FileInputStream(fileName1);
            FileOutputStream fos = new FileOutputStream(fileName2);
            StringBuilder sbNum = new StringBuilder();
            while (fis.available() > 0) {
                int aByte = fis.read();
                if (aByte == 32) {
                    fos.write(roundToInt(sbNum));
                    fos.write(32);
                    sbNum.delete(0, sbNum.length());
                    continue;
                }
                sbNum.append((char) aByte);
            }
            fos.write(roundToInt(sbNum));
            fis.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static byte[] roundToInt(StringBuilder sbNum) {
        String sNum = sbNum.toString();
        Long integer = Math.round(Double.parseDouble(sNum));
        return integer.toString().getBytes();
    }
}
