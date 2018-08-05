package com.javarush.task.task20.task2020;

import java.io.PrintStream;
import java.util.logging.Logger;
import java.io.*;

/* 
Сериализация человека
*/
public class Solution {

    public static class Person implements Serializable {
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) {
        File file = new File("/home/micredis/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2020/temp.ser");
        try (
                FileOutputStream outputStream = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(outputStream);
                FileInputStream inputStream = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(inputStream)
        ) {
            Person person = new Person("Ludwig", "Beethoven", "Holy Roman Empire", Sex.MALE);
            oos.writeObject(person);

            // recovering the person
            Person loadedPersonStub = (Person) ois.readObject();
            Person reconstructedPerson = new Person(
                    loadedPersonStub.firstName,
                    loadedPersonStub.lastName,
                    loadedPersonStub.country,
                    loadedPersonStub.sex
            );
            System.out.println(reconstructedPerson.fullName);
            System.out.println(reconstructedPerson.greetingString + reconstructedPerson.firstName);
            System.out.println(reconstructedPerson.country);
            System.out.println(reconstructedPerson.sex);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
