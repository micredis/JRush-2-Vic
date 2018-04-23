package com.javarush.task.task07.task0727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Меняем функциональность
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        ArrayList<String> listOddEvenMultiplied = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (s.length() % 2 == 0)
                s = new String(s + " " + s);
            else
                s = new String(s + " " + s + " " + s);
            listOddEvenMultiplied.add(s);
        }

        for (int i = 0; i < listOddEvenMultiplied.size(); i++) {
            System.out.println(listOddEvenMultiplied.get(i));
        }
    }
}
