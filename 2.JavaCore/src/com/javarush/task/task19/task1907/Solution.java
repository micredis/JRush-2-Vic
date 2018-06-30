package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    private static final CharSequence WORLD = "world";
    private String fileName;
    {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            this.fileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countWorlds());
    }

    private int countWorlds() {
        int count = 0;
        try (BufferedReader fileReader = new BufferedReader(new FileReader(this.fileName))) {
            if (fileReader.ready()) {
                String line;
                do {
                    line = fileReader.readLine();
                    String[] words = line.split("\\W");
                    for (String word : words) {
                        if (WORLD.equals(word))
                            count++;
                    }
                } while (fileReader.ready());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
}
