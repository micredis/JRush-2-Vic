package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[3];
        numbers[0] = Integer.parseInt(reader.readLine());
        numbers[1] = Integer.parseInt(reader.readLine());
        numbers[2] = Integer.parseInt(reader.readLine());
        reader.close();
        if (numbers[0] != numbers[1] && numbers[1] == numbers[2]) {
            System.out.println(1);
        } else if (numbers[1] != numbers[2] && numbers[2] == numbers[0]) {
            System.out.println(2);
        } else if (numbers[2] != numbers[0] && numbers[0] == numbers[1]) {
            System.out.println(3);
        }
    }
}
