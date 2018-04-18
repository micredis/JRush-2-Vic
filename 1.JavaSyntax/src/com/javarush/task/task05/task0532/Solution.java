package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = Integer.MIN_VALUE;

        //напишите тут ваш код
        for (int i = 0, n = Integer.parseInt(reader.readLine()); i < n; i++) {
            int num = Integer.parseInt(reader.readLine());
            if (maximum < num) {
                maximum = num;
            }
        }

        System.out.println(maximum);
        reader.close();
    }
}
