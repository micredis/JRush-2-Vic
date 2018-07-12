package com.javarush.task.task20.task2007;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/* 
Как сериализовать JavaRush?
*/
public class Solution {
    public static class JavaRush implements Serializable {
        public List<User> users = new ArrayList<>();
    }

    public static void main(String[] args) {
        try (
                FileOutputStream outputStream = new FileOutputStream(new File("/home/micredis/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2007/test.tmp"));
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                FileInputStream inputStream = new FileInputStream( new File("/home/micredis/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2007/test.tmp"));
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)
        ) {
            JavaRush javaRush = new JavaRush();
            User doug = new User();
            doug.setFirstName("Douglas");
            doug.setLastName("Spalding");
            doug.setBirthDate(new Date());
            doug.setMale(true);
            doug.setCountry(User.Country.OTHER);
            javaRush.users.add(doug);
            objectOutputStream.writeObject(javaRush);

            JavaRush javaRushLoaded = (JavaRush) objectInputStream.readObject();

            System.out.println(javaRush.users.get(0).getFirstName());
            System.out.println(javaRush.users.get(0).getLastName());
            System.out.println(javaRush.users.get(0).getBirthDate());
            System.out.println(javaRush.users.get(0).isMale());
            System.out.println(javaRush.users.get(0).getCountry());

            System.out.println();

            System.out.println(javaRushLoaded.users.get(0).getFirstName());
            System.out.println(javaRushLoaded.users.get(0).getLastName());
            System.out.println(javaRushLoaded.users.get(0).getBirthDate());
            System.out.println(javaRushLoaded.users.get(0).isMale());
            System.out.println(javaRushLoaded.users.get(0).getCountry());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
