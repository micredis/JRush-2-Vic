package com.javarush.task.task08.task0801;

/* 
HashSet из растений
*/

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        new Solution().go();
    }

    private void go() {
        HashSet<String> ediblePlants = new HashSet<>();
        ediblePlants.add("арбуз");
        ediblePlants.add("банан");
        ediblePlants.add("вишня");
        ediblePlants.add("груша");
        ediblePlants.add("дыня");
        ediblePlants.add("ежевика");
        ediblePlants.add("женьшень");
        ediblePlants.add("земляника");
        ediblePlants.add("ирис");
        ediblePlants.add("картофель");
        printSet(ediblePlants);
    }

    private void printSet(Set<?> set) {
        Iterator<?> iterator = set.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next().toString();
            System.out.println(s);
        }
    }
}
