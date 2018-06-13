package com.javarush.task.task17.task1710;

import java.text.DateFormat;
import java.text.ParseException;
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
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat(
            "dd/MM/yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        if (args.length < 2) return;
        String key = args[0];
        int id = -1;
        String name = "";
        Sex sex = null;
        Date dob = null;
        Person person = null;
        int sexIndex;
        switch (key) {
            case CREATE:
                sexIndex = indexOfSex(args);
                for (int i = 1; i < sexIndex; i++) {
                    name += args[i];
                    name += (i != sexIndex - 1) ? " " : "";
                }
                try {
                    sex = Sex.parseSex(args[sexIndex]);
                    dob = DATE_FORMAT.parse(args[sexIndex + 1]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if (sex != null && sex.equals(Sex.MALE)) {
                    person = Person.createMale(name, dob);
                    allPeople.add(person);
                } else if (sex != null && sex.equals(Sex.FEMALE)) {
                    person = Person.createFemale(name, dob);
                    allPeople.add(person);
                }
                id = allPeople.indexOf(person);
                System.out.println(id);
                break;
            case UPDATE:
                try {
                    id = Integer.parseInt(args[1]);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                sexIndex = indexOfSex(args);
                for (int i = 2; i < sexIndex; i++) {
                    name += args[i];
                    name += (i != sexIndex - 1) ? " " : "";
                }
                try {
                    sex = Sex.parseSex(args[sexIndex]);
                    dob = DATE_FORMAT.parse(args[sexIndex + 1]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                try {
                    person = allPeople.get(id);
                } catch (IndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
                if (person != null) {
                    person.setName(name);
                    person.setSex(sex);
                    person.setBirthDay(dob);
                }
                break;
            case DELETE:
                try {
                    id = Integer.parseInt(args[1]);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                try {
                    person = allPeople.get(id);
                } catch (IndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
                if (person != null) {
                    person.setName(null);
                    person.setSex(null);
                    person.setBirthDay(null);
                    allPeople.set(id, person);
                }
                break;
            case INFO:
                try {
                    id = Integer.parseInt(args[1]);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                try {
                    person = allPeople.get(id);
                } catch (IndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
                if (person != null) {
                    System.out.println(person);
                }
                break;
            default:
                break;
        }
//        for (Person prsn : allPeople) {
//            System.out.println(prsn);
//        }
    }

    private static int indexOfSex(String[] args) {
        int sexIndex = -1;
        for (int i = 0; i < args.length; i++) {
            if ("м".equals(args[i]) ||
                "ж".equals(args[i])) {
                sexIndex = i;
                break;
            }
        }
        return sexIndex;
    }
}
