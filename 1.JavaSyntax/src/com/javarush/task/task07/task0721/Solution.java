package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;

        //напишите тут ваш код
        int[] nums = new int[20];
        for (int i = 0; i < 20; i++) {
            nums[i] = Integer.parseInt(reader.readLine());
            if (nums[i] < minimum)
                minimum = nums[i];
            if (nums[i] > maximum)
                maximum = nums[i];
        }

        System.out.print(maximum + " " + minimum);
    }
}
