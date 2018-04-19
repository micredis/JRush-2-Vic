package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    private int oddSum;
    private int evenSum;
    private static final String ODD = "нечетными";
    private static final String EVEN = "четными";

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        new Solution().go();
    }

    private void go() {
        int[] numbers = new int[15];
        populateIntArrayManually(numbers);
        findAndSetOddAndEvenSums(numbers);
        String verdict = (oddSum > evenSum) ? ODD : EVEN;
        System.out.format("В домах с %s номерами проживает больше жителей.%n", verdict);
    }

    private void populateIntArrayManually(int[] numbers) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.parseInt(reader.readLine());
            }
            reader.close();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void findAndSetOddAndEvenSums(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (i % 2 == 0)
                evenSum += numbers[i];
            else
                oddSum += numbers[i];
        }
    }
}
