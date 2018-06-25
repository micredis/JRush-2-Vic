package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    private static final String ENCODE = "-e";
    private static final String DECODE = "-d";
    private String key;
    private String fileName;
    private String fileOutputName;

    // Alt+Shift+F10 -> e -> Enter -> Program arguments:
    // -e /home/lab511a/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1826/source.txt /home/lab511a/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1826/destination.txt
    // -d /home/lab511a/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1826/destination.txt /home/lab511a/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1826/decoded.txt
    public static void main(String[] args) {
        if (args.length < 3) return;
        new Solution().go(args);
    }

    private void go(String[] args) {
        initFields(args);
        codeData(this.key, this.fileName, this.fileOutputName);
    }

    private void initFields(String[] args) {
        this.key = args[0];
        this.fileName = args[1];
        this.fileOutputName = args[2];
    }

    private void codeData(String key, String fileName, String fileOutputName) {
        try (FileInputStream fis = new FileInputStream(fileName)) {
            try (FileOutputStream fos = new FileOutputStream(fileOutputName)) {
                while (fis.available() > 0) {
                    int codedByte;
                    if (ENCODE.equals(key))
                        codedByte = fis.read() + 4;
                    else if (DECODE.equals(key))
                        codedByte = fis.read() - 4;
                    else
                        return;
                    fos.write(codedByte);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
