package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    private static final Set<String> keys;
    static {
        Set<String> set = new HashSet<>();
        set.add("user");
        set.add("loser");
        set.add("coder");
        set.add("proger");
        keys = Collections.unmodifiableSet(set);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        //тут цикл по чтению ключей, пункт 1
        Map<String, Person> people = new HashMap<>();
        key = reader.readLine();
        while (keys.contains(key)) {
            //создаем объект, пункт 2
            person = getPerson(key);
            people.put(key, person);
            doWork(person); //вызываем doWork
            key = reader.readLine();
        }
        reader.close();
    }

    public static void doWork(Person person) {
        // пункт 3
        if (person instanceof Person.User)
            ((Person.User) person).live();
        else if (person instanceof Person.Loser)
            ((Person.Loser) person).doNothing();
        else if (person instanceof Person.Coder)
            ((Person.Coder) person).coding();
        else if (person instanceof Person.Proger)
            ((Person.Proger) person).enjoy();
    }

    private static Person getPerson(String key) {
        Person person = null;
        switch (key) {
            case "user": person = new Person.User();
                break;
            case "loser": person = new Person.Loser();
                break;
            case "coder": person = new Person.Coder();
                break;
            case "proger": person = new Person.Proger();
                break;
            default:
                break;
        }
        return person;
    }
}
