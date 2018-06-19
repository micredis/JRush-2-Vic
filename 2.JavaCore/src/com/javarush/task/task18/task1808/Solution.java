package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        new Solution().go();
    }

    private void go() {
        String[] fileNames = readFileNames(3);
        splitFile(fileNames[0], fileNames[1], fileNames[2]);
    }

    private String[] readFileNames(int num) {
        String[] fileNames = new String[num];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < num; i++) {
            fileNames[i] = scanner.nextLine();
        }
        scanner.close();
        return fileNames;
    }

    private void splitFile(String sourceFileName, String destFileName1, String destFileName2) {
        FileInputStream fis = null;
        FileOutputStream fos1 = null;
        FileOutputStream fos2 = null;
        try {
            fis = new FileInputStream(sourceFileName);
            fos1 = new FileOutputStream(destFileName1);
            fos2 = new FileOutputStream(destFileName2);
            int estSize = fis.available();
            if (estSize > 0) {
                byte[] buffer = new byte[estSize];
                int count = fis.read(buffer);
                int half = (count % 2 == 0) ? count / 2 : count / 2 + 1;
                int secondHalf = estSize - half;
                fos1.write(buffer, 0, half);
                fos2.write(buffer, half, secondHalf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos1 != null) {
                try {
                    fos1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos2 != null) {
                try {
                    fos2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
