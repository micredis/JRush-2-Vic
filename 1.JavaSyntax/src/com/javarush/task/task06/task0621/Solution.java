package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandDadName = reader.readLine();
        Cat grandDad = new Cat(grandDadName);
        String grandMomName = reader.readLine();
        Cat grandMom = new Cat(grandMomName);

        String dadName = reader.readLine();
        Cat dad = new Cat(dadName, null, grandDad);
        String momName = reader.readLine();
        Cat mom = new Cat(momName, grandMom, null);

        String sonName = reader.readLine();
        Cat son = new Cat(sonName, mom, dad);
        String daughterName = reader.readLine();
        Cat daughter = new Cat(daughterName, mom, dad);

        System.out.println(grandDad);
        System.out.println(grandMom);
        System.out.println(dad);
        System.out.println(mom);
        System.out.println(son);
        System.out.println(daughter);
    }

    public static class Cat {
        private String name;
        private Cat father;
        private Cat mother;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat mother, Cat father) {
            this.name = name;
            this.father = father;
            this.mother = mother;
        }

        @Override
        public String toString() {
            if (father == null && mother == null)
                return "Cat name is " + name + ", no mother, no father";
            else if (father == null)
                return "Cat name is " + name + ", mother is " + mother.name + ", no father";
            else if (mother == null)
                return "Cat name is " + name + ", no mother, father is " + father.name;
            else
                return "Cat name is " + name + ", mother is " + mother.name + ", father is " + father.name;
        }
    }

}
