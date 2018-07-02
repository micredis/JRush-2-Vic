package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        // /home/micredis/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1921/people.txt
        if (args.length == 0 || args[0].isEmpty()) return;
        new Solution().go(args);
    }

    private void go(String[] args) {
        String fileName = args[0];
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                String name = parseName(line);
                Date dob = parseDOB(line);
                PEOPLE.add(new Person(name, dob));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        for (Person person : PEOPLE) {
//            System.out.println(person.getName() + ": " + person.getBirthday());
//        }
    }

    private String parseName(String line) {
        String name = "";
        String[] lineSplit = line.split("\\s+");
        for (String str : lineSplit) {
            if (!str.matches("^[0-9]+$")) {
                name += str;
                name += " ";
            }
            else
                break;
        }
        return name.trim();
    }

    private Date parseDOB(String line) {
        Date dob = null;
        String sDOB = "";
        String[] lineSplit = line.split("\\s+");
        for (String str : lineSplit) {
            if (str.matches("^[0-9]+$")) {
                sDOB += str;
                sDOB += " ";
            }
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy");
        try {
            dob = formatter.parse(sDOB.trim());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dob;
    }
}
