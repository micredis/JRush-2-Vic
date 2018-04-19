package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Вначале");
        strings.add(" ");
        strings.add("было ");
        strings.add("слово");
        strings.add(".");
        System.out.println(strings.size());
        for (String s : strings)
            System.out.println(s);
    }
}
