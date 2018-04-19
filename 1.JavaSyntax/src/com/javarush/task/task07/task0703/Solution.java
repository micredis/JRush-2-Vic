package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        String[] strings = new String[10];
        int[] numbers = new int[10];
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            for (int i = 0; i < strings.length; i++) {
                strings[i] = reader.readLine();
                numbers[i] = strings[i].length();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        printIntArray(numbers);
    }

    private static void printIntArray(int[] array) {
        for (int num : array) {
            System.out.println(num);
        }
    }
}
