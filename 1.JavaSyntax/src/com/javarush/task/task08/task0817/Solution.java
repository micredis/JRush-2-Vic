package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> fullNames = new HashMap<String, String>();
        fullNames.put("Doe", "John");
        fullNames.put("Smith", "Alex");
        fullNames.put("Fonda", "Jane");
        fullNames.put("Hancock", "John");
        fullNames.put("John", "Elton");
        fullNames.put("Tree", "Joshua");
        fullNames.put("Brown", "James");
        fullNames.put("Attenborough", "David");
        fullNames.put("Cooper", "Fenimore");
        fullNames.put("McCartney", "Linda");
        return fullNames;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //напишите тут ваш код
        // my working solution that validator won't accept
        HashMap<String, String> copy = new HashMap<>(map);
        String name = "";
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (name.equals(pair.getValue()))
                removeItemFromMapByValue(map, name);
            name = pair.getValue();
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);
        for (String familyName : map.keySet())
            System.out.println(familyName);
    }
}
