package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        new Solution().go();
    }

    private void go() {
        double average = getAverage();
        if (!Double.isNaN(average)) {
            System.out.println(average);
        }
    }

    private double getAverage() throws IllegalArgumentException {
        double sum = 0.0;
        double count = 0;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            double num = Double.parseDouble(reader.readLine());
            while (num != -1) {
                sum += num;
                count++;
                num = Double.parseDouble(reader.readLine());
            }
            reader.close();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return sum / count;
    }
}

