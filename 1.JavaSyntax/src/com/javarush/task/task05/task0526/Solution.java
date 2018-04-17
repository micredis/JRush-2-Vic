package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        System.out.println((new Man("Josh", 25, "McGill University")).toStrng());
        System.out.println((new Man("Jason", 26, "Stanford University")).toStrng());
        System.out.println((new Woman("Johanna", 25, "Colombian University")).toStrng());
        System.out.println((new Woman("Phoebe", 23, "Harvard University")).toStrng());
    }

    //напишите тут ваш код
    public static class Man {
        private String name;
        private int age;
        private String address;

        Man(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public String toStrng() {
            return this.name + " " + this.age + " " + this.address;
        }
    }

    public static class Woman {
        private String name;
        private int age;
        private String address;

        Woman(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public String toStrng() {
            return this.name + " " + this.age + " " + this.address;
        }
    }
}
