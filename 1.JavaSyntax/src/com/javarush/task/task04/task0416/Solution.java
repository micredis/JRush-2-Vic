package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;

public class Solution {
    private double minutes;

    public static void main(String[] args) {
        //напишите тут ваш код
        Solution solution = new Solution();
        solution.readAndSetTime();
        System.out.println(solution.getColor());
    }

    private String getColor() {
        String color;
        double num = (int) this.minutes % 5 + (this.minutes - (int) this.minutes);
        if (num < 3) {
            color = "зелёный";
        } else if (num < 4) {
            color = "жёлтый";
        } else {
            color = "красный";
        }
        return color;
    }

    private void readAndSetTime() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            double minutes = Double.parseDouble(reader.readLine());
            this.minutes = (minutes >= 60) ? (int) minutes % 60 + (minutes - (int) minutes) : minutes;
            reader.close();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}