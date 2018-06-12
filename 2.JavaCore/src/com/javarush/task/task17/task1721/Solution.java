package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName1 = "";
        String fileName2 = "";
        if (scanner.hasNext()) {
            fileName1 = scanner.nextLine();
            fileName2 = scanner.nextLine();
        }
        scanner.close();

        // there are 2 files in the package:
        // /home/lab511a/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task17/task1721/allLines.txt
        // /home/lab511a/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task17/task1721/forRemoveLines.txt
        try {
            BufferedReader fileReader1 = new BufferedReader(new FileReader(fileName1));
            BufferedReader fileReader2 = new BufferedReader(new FileReader(fileName2));
            while (fileReader1.ready()) {
                Solution.allLines.add(fileReader1.readLine());
            }
            while (fileReader2.ready()) {
                Solution.forRemoveLines.add(fileReader2.readLine());
            }
            fileReader1.close();
            fileReader2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Solution solution = new Solution();
        try {
            solution.joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }

//        for (String line : Solution.allLines) {
//            System.out.println(line);
//        }
    }

    public void joinData () throws CorruptedDataException {
        if (Solution.allLines.containsAll(Solution.forRemoveLines)) {
            Solution.allLines.removeAll(Solution.forRemoveLines);
        } else {
            Solution.allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
