package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<Integer> numbers = new ArrayList<>();
        readIntsToList(numbers, 10);
        System.out.println(longestClump(numbers));
    }

    private static int longestClump(List<Integer> list) {
        int longest = (list.size() > 0) ? 1 : 0;
        for (int i = 0; i < list.size() - 1; ) {
            int clumpLen = 1;
            for (; (i + 1 < list.size()) && (list.get(i).equals(list.get(i + 1))); i++) {
                clumpLen++;
            }
            i += (clumpLen > 1) ? 0 : 1;
            longest = (clumpLen > longest) ? clumpLen : longest;
        }
        return longest;
    }

    private static void readIntsToList(List<Integer> list, int numOfEntries) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            for (int i = 0; i < numOfEntries; i++) {
                list.add(Integer.parseInt(reader.readLine()));
            }
            reader.close();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}