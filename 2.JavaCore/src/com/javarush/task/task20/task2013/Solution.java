package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/* 
Externalizable Person
*/
public class Solution {
    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person() {
        }

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeObject(father);
            out.writeObject(mother);
            out.writeInt(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName = (String) in.readObject();
            lastName = (String) in.readObject();
            father = (Person)in.readObject();
            mother = (Person)in.readObject();
            age = in.readInt();
            Object oChildren = in.readObject();
            children = (oChildren instanceof List) ? (List) oChildren : null;
        }
    }

    public static void main(String[] args) {
        Person john = new Person("John", "Smith", 33);
        john.setMother(new Person("Linda", "Johnson", 55));
        john.setFather(new Person("Terry", "Smith", 58));
        Person[] children = {new Person("Mike", "Smith", 10),
                new Person("Anna", "Smith", 3)};
        john.setChildren(Arrays.asList(children));
        System.out.format("Name: %s %s, age: %d%nMother: %s, father: %s%n",
                john.firstName, john.lastName, john.age, john.mother.firstName, john.father.firstName);
        System.out.println("Children:");
        if (john.children != null) {
            for (Person child : john.children)
                System.out.println(child.firstName);
        }
        try (
                FileOutputStream fos = new FileOutputStream("/home/micredis/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2013/person.ser");
                ObjectOutputStream out = new ObjectOutputStream(fos);
                FileInputStream fis = new FileInputStream("/home/micredis/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2013/person.ser");
                ObjectInputStream in  = new ObjectInputStream(fis)

        ) {
            out.writeObject(john);
            Person someone = (Person) in.readObject();
            System.out.println();
            System.out.format("Name: %s %s, age: %d%nMother: %s, father: %s%n",
                    someone.firstName, someone.lastName, someone.age, someone.mother.firstName, someone.father.firstName);
            System.out.println("Children:");
            if (someone.children != null) {
                for (Person child : someone.children)
                    System.out.println(child.firstName);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
