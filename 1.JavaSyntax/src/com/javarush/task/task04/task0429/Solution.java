package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    private static final String POSITIVES = "количество положительных чисел: ";
    private static final String NEGATIVES = "количество отрицательных чисел: ";

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int posCount = 0;
        int negCount = 0;
        if (a > 0)
            posCount++;
        if (a < 0)
            negCount++;
        if (b > 0)
            posCount++;
        if (b < 0)
            negCount++;
        if (c > 0)
            posCount++;
        if (c < 0)
            negCount++;
        System.out.println(NEGATIVES + negCount);
        System.out.println(POSITIVES + posCount);
    }
}
