package com.javarush.task.task07.task0702;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Массив из строчек в обратном порядке
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Solution solution = new Solution();
        String[] strings = new String[10];
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            for (int i = 0; i < 8; i++) {
                strings[i] = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        solution.printStringArrayBackwards(strings);
    }


    private void printStringArrayBackwards(String[] strings) {
        for (int i = strings.length - 1; i >= 0; i--) {
            System.out.println(strings[i]);
        }
    }
}