package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.util.Scanner;

public class Solution {
    private String fileName;

    public static void main(String[] args) throws Exception {
        new Solution().go(args);
    }

    private void go(String[] args) {
        this.fileName = readFileName();
    }

    private String readFileName() {
        String fileName = "";
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext())
            fileName = scanner.nextLine();
        scanner.close();
        return fileName;
    }
}
