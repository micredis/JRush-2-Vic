package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;

public class Solution {
    private int year;

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        new Solution().go();
    }

    private void go() {
        int days;
        setYear();
        if (this.year % 4 == 0 &&
                !(this.year % 100 == 0 && this.year % 400 != 0)) {
            days = 366;
        } else {
            days = 365;
        }
        System.out.println("количество дней в году: " + days);
    }

    public void setYear() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            this.year = Integer.parseInt(reader.readLine());
            reader.close();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void setYear(int year) {
        this.year = year;
    }
}