package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        new Solution().go();
    }

    private void go() {
        String dayName;
        String dayNumber = "";
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            dayNumber = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (dayNumber) {
            case "1": dayName = "понедельник";
            break;
            case "2": dayName = "вторник";
            break;
            case "3": dayName = "среда";
            break;
            case "4": dayName = "четверг";
            break;
            case "5": dayName = "пятница";
            break;
            case "6": dayName = "суббота";
            break;
            case "7": dayName = "воскресенье";
            break;
            default: dayName = "такого дня недели не существует";
            break;
        }
        System.out.println(dayName);
    }
}