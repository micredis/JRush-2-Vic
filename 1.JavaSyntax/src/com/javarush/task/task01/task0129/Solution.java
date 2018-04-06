package com.javarush.task.task01.task0129;

/* 
Считаем длину окружности
*/

public class Solution {
    private static final double PI = 3.14;

    public static void main(String[] args) {
        printCircleLength(5);
    }

    private static void printCircleLength(int radius) {
        //напишите тут ваш код
        double circleLength = 2 * PI * radius;
        System.out.format("%f", circleLength);
    }
}