package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
        }
        reader.close();

        int firstIndexOutOfOrder = ascertainOrder(list);
        if (firstIndexOutOfOrder != -1)
            System.out.println(firstIndexOutOfOrder);
    }

    private static int ascertainOrder(List<String> list) {
        int previousStrLength = !list.isEmpty() ? list.get(0).length() : 0;
        for (int i = 1; i < list.size(); i++) {
            int strLength = list.get(i).length();
            if (previousStrLength > strLength)
                return i;
            previousStrLength = strLength;
        }
        return -1; // the list is ordered
    }
}

