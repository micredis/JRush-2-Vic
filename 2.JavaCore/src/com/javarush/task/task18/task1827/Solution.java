package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        // -c Куртка для сноубордистов, размер XL 10173.999 1234
        if (args.length != 0 && "-c".equals(args[0])) {
            new Solution().go(args);
        }
    }

    private void go(String[] args) {
        // /home/micredis/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1827/pricelist.txt
        String fileName = readFileName();
        createRecord(args, fileName);
    }

    private void createRecord(String[] args, String fileName) {
        int id = getMaxID(fileName) + 1;
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName, true))) {
            String record = String.format("%-8d%-30.30s%-8.8s%-4.4s", id, args[1], args[2], args[3]);
            if (id != 1)
                fileWriter.newLine();
            fileWriter.write(record);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readFileName() {
        String fileName;
        Scanner scanner = new Scanner(System.in);
        fileName = scanner.nextLine();
        scanner.close();
        return fileName;
    }

    private int getMaxID(String fileName) {
        int maxID = 0;
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            int id;
            while (fileReader.ready()) {
                String line = fileReader.readLine();
                id = Integer.parseInt(line.substring(0, 8).trim());
                if (id > maxID)
                    maxID = id;
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return maxID;
    }
}
