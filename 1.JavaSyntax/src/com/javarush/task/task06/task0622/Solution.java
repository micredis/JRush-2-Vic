package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        int[] numbers = new int[5];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(reader.readLine());
        }
        reader.close();

        for (int i : sort(numbers)) {
            System.out.println(i);
        }
    }

    private static int[] sort(int[] numbers) {
        int[] sorted = new int[numbers.length];
        System.arraycopy(numbers, 0, sorted, 0, sorted.length);
        boolean isSorted = false;
        while (!isSorted){
            isSorted = true;
            for (int i = 1; i < sorted.length; i++) {
                if (sorted[i - 1] > sorted[i]) {
                    int temp = sorted[i];
                    sorted[i] = sorted[i -1];
                    sorted[i - 1] = temp;
                    isSorted = false;
                }
            }
        }
        return sorted;
    }
}
