package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream console = System.in;
        InputStreamReader inputStreamReader = new InputStreamReader(console);
        BufferedReader consoleReader = new BufferedReader(inputStreamReader);
        String fileName = consoleReader.readLine();
        consoleReader.close();

        FileInputStream fis = new FileInputStream(fileName);
        Set<Integer> byteSet = new TreeSet<>();
        while (fis.available() > 0) {
            byteSet.add(fis.read());
        }
        fis.close();

        StringBuilder sb = new StringBuilder();
        for (Integer value : byteSet) {
            sb.append(value);
            sb.append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
