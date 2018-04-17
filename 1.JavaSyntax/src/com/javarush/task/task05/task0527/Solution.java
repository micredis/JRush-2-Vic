package com.javarush.task.task05.task0527;

/* 
Том и Джерри
*/

public class Solution {
    public static void main(String[] args) {
        Mouse jerryMouse = new Mouse("Jerry", 12, 5);

        //напишите тут ваш код
        Dog doggyDog = new Dog("Doggy", 45, 1);
        Cat tomCat = new Cat("Tomas", 4, 35);
    }

    public static class Mouse {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail) {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    //напишите тут ваш код
    public static class Dog {
        String name;
        int height;
        int age;

        public Dog(String name, int height, int age) {
            this.name = name;
            this.height = height;
            this.age = age;
        }
    }

    public static class Cat {
        String name;
        int weight;
        int tail;

        public Cat(String name, int weight, int tail) {
            this.name = name;
            this.weight = weight;
            this.tail = tail;
        }
    }
}
