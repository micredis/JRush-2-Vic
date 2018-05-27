package com.javarush.task.task15.task1514;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        Map<Double, String> map = new HashMap<Double, String>();
        map.put(1d, "one");
        map.put(2.5, "two and a half");
        map.put(3.7, "three point seven");
        map.put(4.25, "four and a quarter");
        map.put(5.33, "five and a third");
        labels = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
