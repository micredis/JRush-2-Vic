package com.javarush.task.task08.task0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Минимальное из N чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        // find minimum here — найти минимум тут
        int min = (array.size() > 0) ? array.get(0) : Integer.MAX_VALUE;
        for (int i : array) {
            if (i < min)
                min = i;
        }
        return min;
    }

    public static List<Integer> getIntegerList() throws IOException, NumberFormatException {
        //create and initialize a list here - создать и заполнить список тут
        List<Integer> numbers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        for (int i = 0; i < count; i++) {
            numbers.add(Integer.parseInt(reader.readLine()));
        }
        reader.close();
        return numbers;
    }
}
