package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        reader.close();
        int positiveCount = 0;
        if (a > 0) {
            positiveCount++;
        }
        if (b > 0) {
            positiveCount++;
        }
        if (c > 0) {
            positiveCount++;
        }
        System.out.println(positiveCount);
    }
}
