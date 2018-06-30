package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    private static final String PUNCT_REGEX = "[\\p{Punct}\\r\\n]";
    //    the same regex:
    //    private static final String PUNCT_REGEX = "[!\"\\#$%&'()*+,\\-./:;<=>?@\\[\\\\\\]^_`{|}~\\r\\n]";
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
        removePunctuation(this.srcFileName, this.dstFileName);
    }

    private void removePunctuation(String srcFileName, String dstFileName) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(srcFileName))) {
            try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(dstFileName))) {
                while (fileReader.ready()) {
                    String line = fileReader.readLine();
                    fileWriter.write(line.replaceAll(PUNCT_REGEX, ""));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
