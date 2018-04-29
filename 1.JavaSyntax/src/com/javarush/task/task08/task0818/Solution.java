package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> employees = new HashMap<>();
        employees.put("Thatcher", 400);
        employees.put("Carter", 500);
        employees.put("Reagan", 550);
        employees.put("Gorbachev", 450);
        employees.put("Nixon", 1600);
        employees.put("Sakharov", 1700);
        employees.put("Bowie", 1800);
        employees.put("Jagger", 1900);
        employees.put("Mondrian", 2000);
        employees.put("Gosling", 2100);
        return employees;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> pair = iterator.next();
            int salary = pair.getValue();
            if (salary < 500)
                iterator.remove();
        }
    }

    public static void main(String[] args) {
//        HashMap<String, Integer> map = createMap();
//        System.out.println(map.toString());
//        removeItemFromMap(map);
//        System.out.println(map.toString());
    }
}