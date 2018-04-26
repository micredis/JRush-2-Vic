package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));

        //напишите тут ваш код
        map.put("Baboo", new Date("AUG 17 1985"));
        map.put("Caboom", new Date("FEB 19 1986"));
        map.put("Daboom", new Date("APR 4 1973"));
        map.put("Ek", new Date("SEP 28 1979"));
        map.put("Foo", new Date("JUL 15 1984"));
        map.put("Goo", new Date("SEP 28 1983"));
        map.put("Hoo", new Date("OCT 2 1977"));
        map.put("It", new Date("NOV 8 1998"));
        map.put("Jay", new Date("DEC 7 1988"));
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Date> pair = iterator.next();
            int month = pair.getValue().getMonth() + 1;
            if (month >= 6 && month <= 8)
                iterator.remove();
        }
    }

    public static void main(String[] args) {

    }
}
