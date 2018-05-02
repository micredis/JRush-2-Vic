package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        Map<String, String> people = new HashMap<>();
        people.put("Lennon", "John");
        people.put("Harrison", "George");
        people.put("McCartney", "Paul");
        people.put("Starr", "Ringo");
        people.put("Martin", "George");
        people.put("McCartney", "Michael");
        people.put("Ono", "Yoko");
        people.put("McCartney", "Linda");
        people.put("Harrison", "Olivia");
        people.put("Johnson", "John");
        return people;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
