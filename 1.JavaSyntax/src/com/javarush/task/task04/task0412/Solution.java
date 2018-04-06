package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;

public class Solution {
    private int number;


    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        new Solution().go();
    }

    private void go() {
        this.number = readNumber();
        if (this.number > 0) {
            this.number *= 2;
        } else if (this.number < 0) {
            this.number++;
        }
        System.out.println(number);
    }

    private int readNumber() {
        int number = 0;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            number = Integer.parseInt(reader.readLine());
            reader.close();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return number;
    }
}