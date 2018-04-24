package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> fullNames = new HashMap<>();
        fullNames.put("Daniels", "Jack");
        fullNames.put("Gabriel", "Peter");
        fullNames.put("Scolio", "Josh");
        fullNames.put("Spalding", "Douglas");
        fullNames.put("Clifford", "Douglas");
        fullNames.put("Fogerty", "John");
        fullNames.put("Lennon", "John");
        fullNames.put("Johnson", "John");
        fullNames.put("White", "Jack");
        fullNames.put("Newton", "Isaac");
        return fullNames;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int count = 0;
        Iterator<String> iterator = map.values().iterator();
        while (iterator.hasNext()) {
            if (name.equals(iterator.next()))
                count++;
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
        // since keys are unique, the method returns
        // either 0 (no occurrences of lastName)
        // or 1 (one and only occurrence of lastName)
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            if (lastName.equals(iterator.next()))
                return 1;
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
