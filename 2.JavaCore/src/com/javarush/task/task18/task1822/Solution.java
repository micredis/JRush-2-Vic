package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private int id;

    public static void main(String[] args) {
        Solution sol = new Solution();
        if (args.length == 0 || args[0].isEmpty()) return;
        sol.setId(Integer.parseInt(args[0]));
        String fileName = readFileName();
        System.out.println(sol.getRecord(fileName, sol.getId()));
    }

    private static String readFileName() {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();
        return fileName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    private String getRecord(String fileName, int id) {
        String record = "";
        try (FileInputStream fis = new FileInputStream(fileName)) {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(fis));
            String line;
            do {
                line = fileReader.readLine();
                if (line.startsWith(String.valueOf(id) + " ")) {
                    record = line;
                    break;
                }
            } while (fileReader.ready());
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return record;
    }
}
