package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<Human> people = new ArrayList<>();

        Human kid1 = new Human("Kid A", true, 2);
        people.add(kid1);
        Human kid2 = new Human("Kid B", true, 5);
        people.add(kid2);
        Human kid3 = new Human("Kid C", false, 9);
        people.add(kid3);

        ArrayList<Human> gen3 = new ArrayList<>(people);

        Human father = new Human("Dad", true, 33, gen3);
        people.add(father);
        Human mother = new Human("Mom", false, 30, gen3);
        people.add(mother);

        ArrayList<Human> gen2a = new ArrayList<>();
        gen2a.add(father);
        ArrayList<Human> gen2b = new ArrayList<>();
        gen2b.add(mother);

        Human grandFather1 = new Human("Grandfather 1", true, 65, gen2a);
        people.add(grandFather1);
        Human grandFather2 = new Human("Grandfather 2", true, 67, gen2b);
        people.add(grandFather2);
        Human grandMother1 = new Human("Grandmother 1", false, 62, gen2a);
        people.add(grandMother1);
        Human grandMother2 = new Human("Grandmother 2", false, 61, gen2b);
        people.add(grandMother2);

        for (Human person : people)
            System.out.println(person);
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        Human() {
        }

        Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = new ArrayList<>();
        }

        Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
