package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String fileName1 = scanner.nextLine();
        String fileName2 = scanner.nextLine();
        String fileName3 = scanner.nextLine();
        scanner.close();

        // /home/lab511a/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1818/file1.txt
        // /home/lab511a/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1818/file2.txt
        // /home/lab511a/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1818/file3.txt
        FileOutputStream fos = new FileOutputStream(fileName1);
        FileInputStream fis1 = new FileInputStream(fileName2);
        FileInputStream fis2 = new FileInputStream(fileName3);
        byte[] buffer1 = new byte[fis1.available()];
        while (fis1.available() > 0) {
            int count = fis1.read(buffer1);
            fos.write(buffer1, 0, count);
        }
        byte[] buffer2 = new byte[fis2.available()];
        while (fis2.available() > 0) {
            int count = fis2.read(buffer2);
            fos.write(buffer2, 0, count);
        }
        fis1.close();
        fis2.close();
        fos.close();
    }
}
