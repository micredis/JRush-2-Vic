package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // /home/lab511a/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1824/file1.txt
        // /home/lab511a/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1824/file2.txt
        // /home/lab511a/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1824/file3.txt
        String fileName = null;
        List<FileInputStream> inputStreams = new ArrayList<>();
        try {
            while (true) {
                fileName = reader.readLine();
                inputStreams.add(new FileInputStream(fileName));
            }
        } catch (FileNotFoundException e) {
            System.out.println(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                for (FileInputStream inputStream : inputStreams) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
