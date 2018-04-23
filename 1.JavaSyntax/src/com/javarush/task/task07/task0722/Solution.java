package com.javarush.task.task07.task0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Это конец
*/

public class Solution {
    private static final String END_TRIGGER = "end";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        for (String s = reader.readLine(); !END_TRIGGER.equals(s); ) {
            list.add(s);
            s = reader.readLine();
        }
        reader.close();
        for (String s : list)
            System.out.println(s);
    }
}