package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    private String srcFileName;
    private String dstFileName;
    {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            this.srcFileName = reader.readLine();
            this.dstFileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Solution().go();
    }

    private void go() {
        writeNumbers(this.srcFileName, this.dstFileName);
    }

    private void writeNumbers(String srcFileName, String dstFileName) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(srcFileName))){
            try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(dstFileName))) {
                if (!fileReader.ready()) return;
                String line;
                while (fileReader.ready()) {
                    line = fileReader.readLine();
                    String[] wordsAndNumbers = line.split("[^0-9A-Za-zА-Яа-я\\-]");
                    for (int i = 0; i < wordsAndNumbers.length; i++) {
                        String value = wordsAndNumbers[i];
                        if (value.matches("-?\\d+")) {
                            fileWriter.write(value);
                            if (fileReader.ready() || i < wordsAndNumbers.length - 1) {
                                fileWriter.write(" ");
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
