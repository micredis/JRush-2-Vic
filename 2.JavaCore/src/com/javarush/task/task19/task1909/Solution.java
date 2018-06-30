package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    private static final String PERIOD = "\\.";
    private static final String EXCLAM = "!";
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
        period2Exclam(this.srcFileName, this.dstFileName);
    }

    private void period2Exclam(String srcFileName, String dstFileName) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(srcFileName))) {
            try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(dstFileName))) {
                String line;
                while (fileReader.ready()) {
                    line = fileReader.readLine();
                    fileWriter.write(line.replaceAll(PERIOD, EXCLAM));
                    if (fileReader.ready())
                        fileWriter.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
