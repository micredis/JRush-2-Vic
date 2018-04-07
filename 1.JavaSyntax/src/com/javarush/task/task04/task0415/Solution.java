package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.*;

public class Solution {
    private double a;
    private double b;
    private double c;

    public static void main(String[] args) {
        //напишите тут ваш код
        Solution solution = new Solution();
        solution.readABC();
        String particle = solution.isTriangleExist(solution.a, solution.b, solution.c) ? " " : " не ";
        System.out.println("Треугольник" + particle + "существует.");
    }

    private void readABC() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            this.a = Double.parseDouble(reader.readLine());
            this.b = Double.parseDouble(reader.readLine());
            this.c = Double.parseDouble(reader.readLine());
            reader.close();
        } catch (IOException | NumberFormatException ex) {
            ex.printStackTrace();
        }
    }

    private boolean isTriangleExist(double a, double b, double c) {
        return a + b > c &&
                a + c > b &&
                b + c > a;
    }
}