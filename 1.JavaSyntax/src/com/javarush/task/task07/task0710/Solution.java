package com.javarush.task.task07.task0710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
В начало списка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> stringList = new ArrayList<>();
        Solution.readStringsToList(stringList, 10);
        Solution.printStringList(stringList);
    }

    private static void readStringsToList(List<String> stringList, int numOfStrings) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            for (int i = 0; i < numOfStrings; i++) {
                stringList.add(0, reader.readLine());
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printStringList(List<String> stringList) {
        for (String s : stringList)
            System.out.println(s);
    }
}
