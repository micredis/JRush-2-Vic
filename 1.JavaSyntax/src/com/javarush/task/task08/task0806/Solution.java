package com.javarush.task.task08.task0806;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

/* 
Коллекция HashMap из Object
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("Sim", 5);
        map.put("Tom", 5.5);
        map.put("Arbus", false);
        map.put("Baby", null);
        map.put("Cat", "Cat");
        map.put("Eat", new Long(56));
        map.put("Food", new Character('3'));
        map.put("Gevey", '6');
        map.put("Hugs", 111111111111L);
        map.put("Comp", (double) 123);

        //напишите тут ваш код
        printMap(map);
    }

    private static void printMap(Map<?, ?> map) {
        Iterator<? extends Map.Entry<?, ?>> mapIterator = map.entrySet().iterator();
        while (mapIterator.hasNext()) {
            Map.Entry<?, ?> pair = mapIterator.next();
            Object oKey = pair.getKey();
            Object oValue = pair.getValue();
            String sKey = oKey != null ? oKey.toString() : null;
            String sValue = oValue != null ? oValue.toString() : null;
            System.out.format("%s - %s%n", sKey, sValue);
        }
    }
}
