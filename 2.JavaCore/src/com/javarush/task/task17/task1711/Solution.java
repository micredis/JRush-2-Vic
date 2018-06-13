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
    private static final List<Integer> selectedIDs = new ArrayList<Integer>();
    private static final List<Person> selectedPeople = new ArrayList<Person>();
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
            // TODO: revise CREATE case to accept multiple records
            case CREATE:
                List<Integer> createIndices = new ArrayList<Integer>();
                for (int i = 3; i < args.length; i++) {
                    if (isSex(args[i])) {
                        createIndices.add(i - 1);
                    }
                }
                synchronized (allPeople) {
                    sexIndex = indexOfSex(args, 0);
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
                }
                break;
            case UPDATE:
                List<Integer> idIndices = new ArrayList<Integer>();
                idIndices.add(1);
                for (int i = 2; i < args.length - 2; i++) {
                    if (isSex(args[i])) {
                        idIndices.add(i + 2);
                    }
                }
                synchronized (allPeople) {
                    try {
                        for (Integer idIndex : idIndices) {
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
                        for (int i = 1; i < args.length; i++) {
                            selectedIDs.add(Integer.parseInt(args[i]));
                        }
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    try {
                        for (Integer selectedID : selectedIDs) {
                            person = allPeople.get(selectedID);
                            if (person != null) {
                                person.setName(null);
                                person.setSex(null);
                                person.setBirthDay(null);
                                allPeople.set(selectedID, person);
                            }
                        }
                    } catch (IndexOutOfBoundsException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case INFO:
                synchronized (allPeople) {
                    try {
                        for (int i = 1; i < args.length; i++) {
                            selectedIDs.add(Integer.parseInt(args[i]));
                        }
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    try {
                        for (Integer selectedID : selectedIDs) {
                            person = allPeople.get(selectedID);
                            selectedPeople.add(person);
                        }
                    } catch (IndexOutOfBoundsException e) {
                        e.printStackTrace();
                    }
                    for (Person selectedPerson : selectedPeople) {
                        System.out.println(selectedPerson);
                    }
                }
                break;
            default:
                break;
        }
        // TODO: remove the loop below (for - sout)
        for (Person prsn : allPeople) {
            System.out.println(prsn);
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
