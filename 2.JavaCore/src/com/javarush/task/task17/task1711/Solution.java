package com.javarush.task.task17.task1711;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    private static final List<Integer> SELECTED_IDs = new ArrayList<Integer>();
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
        int id = -1;
        String name = "";
        Sex sex = null;
        Date dob = null;
        Person person = null;
        int sexIndex;
        List<Integer> recordIndices = new ArrayList<Integer>();
        switch (args[0]) {
            case CREATE:
                recordIndices.add(1);
                for (int i = 1; i < args.length - 2; i++) {
                    if (isSex(args[i])) {
                        recordIndices.add(i + 2);
                    }
                }
                synchronized (allPeople) {
                    try {
                        for (Integer nameIndex : recordIndices) {
                            for (int i = nameIndex; !isSex(args[i]); i++) {
                                name += args[i];
                                name += " ";
                            }
                            name = name.trim();
                            sexIndex = indexOfSex(args, nameIndex + 1);
                            sex = Sex.parseSex(args[sexIndex]);
                            dob = DATE_FORMAT.parse(args[sexIndex + 1]);
                            if (sex != null && sex.equals(Sex.MALE)) {
                                person = Person.createMale(name, dob);
                            } else if (sex != null && sex.equals(Sex.FEMALE)) {
                                person = Person.createFemale(name, dob);
                            }
                            allPeople.add(person);
                            id = allPeople.lastIndexOf(person);
                            System.out.println(id);
                            name = "";
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case UPDATE:
                recordIndices.add(1);
                for (int i = 2; i < args.length - 2; i++) {
                    if (isSex(args[i])) {
                        recordIndices.add(i + 2);
                    }
                }
                synchronized (allPeople) {
                    try {
                        for (Integer idIndex : recordIndices) {
                            id = Integer.parseInt(args[idIndex]);
                            for (int i = idIndex + 1; !isSex(args[i]); i++) {
                                name += args[i];
                                name += " ";
                            }
                            name = name.trim();
                            sexIndex = indexOfSex(args, idIndex + 2);
                            sex = Sex.parseSex(args[sexIndex]);
                            dob = DATE_FORMAT.parse(args[sexIndex + 1]);
                            person = allPeople.get(id);
                            if (person != null) {
                                person.setName(name);
                                person.setSex(sex);
                                person.setBirthDay(dob);
                            }
                            name = "";
                        }
                    } catch (NumberFormatException | ParseException | IndexOutOfBoundsException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case DELETE:
                synchronized (allPeople) {
                    try {
                        synchronized (SELECTED_IDs) {
                            for (int i = 1; i < args.length; i++) {
                                SELECTED_IDs.add(Integer.parseInt(args[i]));
                            }
                        }
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    try {
                        synchronized (SELECTED_IDs) {
                            for (Integer selectedID : SELECTED_IDs) {
                                if (selectedID < allPeople.size()) {
                                    person = allPeople.get(selectedID);
                                    if (person != null) {
                                        person.setName(null);
                                        person.setSex(null);
                                        person.setBirthDay(null);
                                        allPeople.set(selectedID, person);
                                    }
                                }
                            }
                        }
                    } catch (IndexOutOfBoundsException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case INFO:
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        try {
                            id = Integer.parseInt(args[i]);
                            System.out.println(allPeople.get(id));
                        } catch (NumberFormatException | IndexOutOfBoundsException e) {
                            e.printStackTrace();
                        }
                    }
                }
                break;
            default:
                synchronized (allPeople) {
                }
                break;
        }
    }

    private static int indexOfSex(String[] args, int offset) {
        int sexIndex = -1;
        for (int i = offset; i < args.length; i++) {
            if (isSex(args[i])) {
                sexIndex = i;
                break;
            }
        }
        return sexIndex;
    }

    private static boolean isSex(String s) {
        return "м".equals(s) || "ж".equals(s);
    }
}
