package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        List<Human> humans = new ArrayList<>();
        Human grandDad1 = new Human("Adam", true, 100);
        humans.add(grandDad1);
        Human grandMom1 = new Human("Eve", false, 99);
        humans.add(grandMom1);
        Human grandDad2 = new Human("Pham", true, 1024);
        humans.add(grandDad2);
        Human grandMom2 = new Human("Ravna", false, 55);
        humans.add(grandMom2);
        Human father = new Human("David", true, 26, grandDad1, grandMom1);
        humans.add(father);
        Human mother = new Human("Johanna", false, 25, grandDad2, grandMom2);
        humans.add(mother);
        Human son1 = new Human("Scriber", true, 3, father, mother);
        humans.add(son1);
        Human son2 = new Human("Tycoon", true, 2, father, mother);
        humans.add(son2);
        Human daughter1 = new Human("Woodcarver", false, 1, father, mother);
        humans.add(daughter1);
        for (Human h : humans)
            System.out.println(h);
    }

    public static class Human {
        //напишите тут ваш код
        private String name;
        private int age;
        private boolean sex;
        private Human father;
        private Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















