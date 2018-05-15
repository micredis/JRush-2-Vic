package com.javarush.task.task12.task1226;

/* 
Лазать, летать и бегать
*/

public class Solution {

    public static void main(String[] args) {
//        new Solution().go();
    }

    /*private void go() {
        Cat cat = new Cat();
        cat.run();
        cat.climb();
        Dog dog = new Dog();
        dog.run();
        Cat tiger = new Tiger();
        tiger.run();
        tiger.climb();
        Duck duck = new Duck();
        duck.fly();
        duck.run();
    }*/

    public class Cat implements Run, Climb {
        @Override
        public void run() {
            System.out.println(this + "'s running");
        }

        @Override
        public void climb() {
            System.out.println(this + "'s climbing");
        }

        @Override
        public String toString() {
            return this.getClass().getSimpleName();
        }
    }

    public class Dog implements Run {
        @Override
        public void run() {
            System.out.println(this + "'s running");
        }

        @Override
        public String toString() {
            return this.getClass().getSimpleName();
        }
    }

    public class Tiger extends Cat {
    }

    public class Duck implements Fly, Run {
        @Override
        public void fly() {
            System.out.println(this + "'s flying");
        }

        @Override
        public void run() {
            System.out.println(this + "'s running");
        }

        @Override
        public String toString() {
            return this.getClass().getSimpleName();
        }
    }

    public interface Fly {
        void fly();
    }

    public interface Climb {
        void climb();
    }

    public interface Run {
        void run();
    }
}
