package com.javarush.task.task04.task0425;

/* 
Цель установлена!
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        reader.close();
        int quarter;
        if (a > 0 && b > 0)
            quarter = 1;
        else if (a < 0 && b > 0)
            quarter = 2;
        else if (a < 0 && b < 0)
            quarter = 3;
        else
            quarter = 4;
        System.out.println(quarter);
    }
}
