package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private String sureName;
        private String name;
        private boolean gender;
        private int age;
        private int weight;
        private Human spouse;

        public Human() {
            this.sureName = "";
            this.name = "";
            this.gender = false;
            this.age = 0;
            this.weight = 0;
            this.spouse = null;
        }

        public Human(String sureName) {
            this.sureName = sureName;
            this.name = "";
            this.gender = false;
            this.age = 0;
            this.weight = 0;
            this.spouse = null;
        }

        public Human(String sureName, String name) {
            this.sureName = sureName;
            this.name = name;
            this.gender = false;
            this.age = 0;
            this.weight = 0;
            this.spouse = null;
        }

        public Human(String sureName, String name, boolean gender) {
            this.sureName = sureName;
            this.name = name;
            this.gender = gender;
            this.age = 0;
            this.weight = 0;
            this.spouse = null;
        }

        public Human(String sureName, String name, boolean gender,
                     int age) {
            this.sureName = sureName;
            this.name = name;
            this.gender = gender;
            this.age = age;
            this.weight = 0;
            this.spouse = null;
        }

        public Human(String sureName, String name, boolean gender,
                     int age, int weight) {
            this.sureName = sureName;
            this.name = name;
            this.gender = gender;
            this.age = age;
            this.weight = weight;
            this.spouse = null;
        }

        public Human(String sureName, String name, boolean gender,
                     int age, int weight, Human spouse) {
            this.sureName = sureName;
            this.name = name;
            this.gender = gender;
            this.age = age;
            this.weight = weight;
            this.spouse = spouse;
        }

        public Human(Human human) {
            this.sureName = human.getSureName();
            this.name = human.getName();
            this.gender = human.isMale();
            this.age = human.getAge();
            this.weight = human.getWeight();
            this.spouse = human.getSpouse();
        }

        public Human(String sureName, String name, Human spouse) {
            this.sureName = sureName;
            this.name = name;
            this.gender = false;
            this.age = 0;
            this.weight = 0;
            this.spouse = spouse;
        }

        public Human(Human human, Human spouse) {
            this.sureName = human.getSureName();
            this.name = human.getName();
            this.gender = human.isMale();
            this.age = human.getAge();
            this.weight = human.getWeight();
            this.spouse = spouse;
        }

        public String getSureName() {
            return this.sureName;
        }

        public String getName() {
            return this.name;
        }

        public boolean isMale() {
            return this.gender;
        }

        public int getAge() {
            return this.age;
        }

        public int getWeight() {
            return this.weight;
        }

        public Human getSpouse() {
            return this.spouse;
        }
    }
}
