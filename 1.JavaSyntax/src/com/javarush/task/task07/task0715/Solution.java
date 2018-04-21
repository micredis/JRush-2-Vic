package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();
        list.add("мама");
        list.add("мыла");
        list.add("раму");

        int size = list.size();
        for (int i = 0; i < size + 2; i += 2) {
            list.add(i + 1, "именно");
        }

        for (String s : list)
            System.out.println(s);
    }
}
