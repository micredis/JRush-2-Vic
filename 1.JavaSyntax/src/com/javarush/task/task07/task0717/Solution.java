package com.javarush.task.task07.task0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;

/* 
Удваиваем слова
*/

public class Solution {
    public static void main(String[] args) {
        // Считать строки с консоли и объявить ArrayList list тут
        ArrayList<String> list = new ArrayList<>();
        readStringsToList(list, 10);

        ArrayList<String> result = doubleValues(list);

        // Вывести на экран result
        for (String s : result)
            System.out.println(s);
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        //напишите тут ваш код
        int listDoubleSize = 2 * list.size();
        for (int i = 0; i < listDoubleSize; i += 2) {
            list.add(i, list.get(i));
        }
        return list;
    }

    private static void readStringsToList(ArrayList<String> list, int numOfEntries) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            for (int i = 0; i < numOfEntries; i++) {
                list.add(reader.readLine());
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
