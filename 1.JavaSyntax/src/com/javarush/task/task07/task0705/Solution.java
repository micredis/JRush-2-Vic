package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        new Solution().go();
    }

    private void go() {
        int[] numbersAB = new int[20];
        populateArrayManually(numbersAB);
        int[] numbersA = new int[10];
        int[] numbersB = new int[10];
        System.arraycopy(numbersAB, 0, numbersA, 0, numbersAB.length / 2);
        System.arraycopy(numbersAB, numbersAB.length / 2, numbersB, 0, numbersAB.length / 2);
        printIntArray(numbersB);
    }

    private void populateArrayManually(int[] array) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            for (int i = 0; i < array.length; i++) {
                array[i] = Integer.parseInt(reader.readLine());
            }
            reader.close();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void printIntArray(int[] array) {
        for (int num : array) {
            System.out.println(num);
        }
    }
}
