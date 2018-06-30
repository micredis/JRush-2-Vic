package com.javarush.task.task19.task1906;

/* 
Четные символы
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
        Solution solution = new Solution();
        solution.writeEvenSymbols(solution.srcFileName, solution.dstFileName);
    }

    private void writeEvenSymbols(String srcFileName, String dstFileName) {
        try (FileReader fileReader = new FileReader(srcFileName)) {
            try (FileWriter fileWriter = new FileWriter(dstFileName)) {
                for (int i = 1; fileReader.ready(); i++) {
                    if (i % 2 == 0) {
                        int symbol = fileReader.read();
                        fileWriter.write(symbol);
                    } else {
                        fileReader.skip(1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
