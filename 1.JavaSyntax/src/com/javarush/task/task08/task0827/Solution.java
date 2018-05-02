package com.javarush.task.task08.task0827;

import java.util.Date;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) {
        long dateMs = Date.parse(date);
        Date realDate = new Date(dateMs);
        Date janFirst = new Date();
        janFirst.setHours(0);
        janFirst.setMinutes(0);
        janFirst.setSeconds(0);
        janFirst.setDate(1);
        janFirst.setMonth(0);
        janFirst.setYear(realDate.getYear());
        long msPerDay = 24 * 60 * 60 * 1000;
        int daysPassed = (int) ((realDate.getTime() - janFirst.getTime()) / msPerDay);
        return daysPassed % 2 != 0;
    }
}
