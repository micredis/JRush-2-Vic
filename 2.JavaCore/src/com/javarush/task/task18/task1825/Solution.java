package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

/* 
Собираем файл
*/

public class Solution {
    private Set<String> fileNames = new TreeSet<>();
    private FileOutputStream fos;

    public static void main(String[] args) {
        new Solution().go();
    }

    private void go() {
        readFileNames();
        if (!initFileOutputStream())
            return;
        mergeFiles(fileNames);
        closeFos(this.fos);
    }

    // /home/lab511a/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1825/song.txt.part1
    // /home/lab511a/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1825/song.txt.part2
    // /home/lab511a/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1825/song.txt.part3
    private void readFileNames() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = reader.readLine();
            while (!"end".equals(fileName)) {
                this.fileNames.add(fileName);
                fileName = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // returns true if this.fos is initialized successfully,
    // false otherwise
    private boolean initFileOutputStream() {
        if (this.fileNames.isEmpty()) return false;
        for (String fileName : fileNames) {
            if (fileName != null) {
                int suffixIndex = fileName.lastIndexOf(".part");
                String outFileName = fileName.substring(0, suffixIndex);
                try {
                    fos = new FileOutputStream(outFileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return true;
            }
        }
        return false;
    }

    private void mergeFiles(Set<String> fileNames) {
        try {
            for (String fileName : fileNames) {
                FileInputStream fis = new FileInputStream(fileName);
                int bufSize = (fis.available() > 1000000) ? 1000000 : fis.available();
                byte[] buffer = new byte[bufSize];
                while (fis.available() > 0) {
                    int count = fis.read(buffer);
                    this.fos.write(buffer, 0, count);
                }
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeFos(FileOutputStream fos) {
        if (fos != null) {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
