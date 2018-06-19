package com.javarush.task.task18.task1809;

/* 
Реверс файла
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
        String[] fileNames = readFileNames(2);
        String source = fileNames[0]; // /home/lab511a/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1809/source.txt
        String destin = fileNames[1]; // /home/lab511a/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1809/destination.txt
        writeDataBackwards(source, destin);
    }

    private String[] readFileNames(int numOfFiles) {
        String[] fileNames = new String[numOfFiles];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < numOfFiles; i++) {
            fileNames[i] = scanner.nextLine();
        }
        scanner.close();
        return fileNames;
    }

    private void writeDataBackwards(String sourceName, String destName) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(sourceName);
            fos = new FileOutputStream(destName);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            for (int i = buffer.length - 1; i >= 0; i--) {
                fos.write(buffer, i, 1);
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
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
