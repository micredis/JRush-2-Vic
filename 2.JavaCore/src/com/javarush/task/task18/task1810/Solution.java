package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws DownloadException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String fileName = scanner.nextLine();
            try (FileInputStream fis = new FileInputStream(fileName)) {
                int fileSize = fis.available();
                if (fileSize < 1000) {
                    scanner.close();
                    throw new DownloadException();
                }
            } catch (IOException ignored) {
            }
        }
    }

    public static class DownloadException extends Exception {

    }
}
