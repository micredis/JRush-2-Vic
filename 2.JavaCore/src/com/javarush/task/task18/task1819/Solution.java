package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        // /home/lab511a/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1819/destination.txt
        // /home/lab511a/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1819/source.txt
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = console.readLine();
        String fileName2 = console.readLine();
        console.close();

        FileInputStream fis1 = new FileInputStream(fileName1);
        byte[] buffer1 = new byte[fis1.available()];
        if (fis1.available() > 0) {
            fis1.read(buffer1);
        }

        FileOutputStream fos = new FileOutputStream(fileName1);
        FileInputStream fis2 = new FileInputStream(fileName2);
        byte[] buffer2 = new byte[fis2.available()];
        if (fis2.available() > 0) {
            fis2.read(buffer2);
        }
        fos.write(buffer2);
        fos.write(buffer1);

        fis1.close();
        fis2.close();
        fos.close();
    }
}
