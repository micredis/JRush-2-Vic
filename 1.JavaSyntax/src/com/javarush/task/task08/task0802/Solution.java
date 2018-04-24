package com.javarush.task.task08.task0802;

/* 
HashMap из 10 пар
*/

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        new Solution().go();
    }

    private void go() {
        HashMap<String, String> plants = new HashMap<>();
        plants.put("арбуз", "ягода");
        plants.put("банан", "трава");
        plants.put("вишня", "ягода");
        plants.put("груша", "фрукт");
        plants.put("дыня", "овощ");
        plants.put("ежевика", "куст");
        plants.put("жень-шень", "корень");
        plants.put("земляника", "ягода");
        plants.put("ирис", "цветок");
        plants.put("картофель", "клубень");
        printMap(plants);
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
