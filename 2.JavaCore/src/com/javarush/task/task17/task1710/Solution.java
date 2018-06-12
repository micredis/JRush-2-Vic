package com.javarush.task.task17.task1710;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    private static final String CREATE = "-c";
    private static final String UPDATE = "-u";
    private static final String DELETE = "-d";
    private static final String INFO = "-i";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
            "dd/MM/yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        switch (args[0]) {
            case CREATE:
                if (Sex.MALE.toString().equals(args[2])) {
                    allPeople.add(Person.createMale(args[1], ...));
                }
        }
    }
}
