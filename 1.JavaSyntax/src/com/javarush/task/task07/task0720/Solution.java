package com.javarush.task.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Перестановочка подоспела
*/

public class Solution {
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<>();
        int n = Integer.parseInt(reader.readLine()); // number of srings to input
        int m = Integer.parseInt(reader.readLine()); // number of strings to move to the end
        for (int i = 0; i < n; i++) {
            strings.add(reader.readLine());
        }
        reader.close();
        // move m first entries to the end of strings list
        for (int i = 0; i < m; i++) {
            strings.add(strings.remove(0));
        }
        for (int i = 0; i < n; i++) {
            System.out.println(strings.get(i));
        }
    }
}
