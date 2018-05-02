package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //map of addresses and names
        Map<String, String> citiesAndFamilies = new HashMap<String, String>();
        while (true) {
            String city = reader.readLine();
            if (city.isEmpty()) break;
            String family = reader.readLine();
            if (family.isEmpty()) break;

            citiesAndFamilies.put(city, family);
        }

        //read city name
        String city = reader.readLine();

        if (citiesAndFamilies.containsKey(city)) {
            String familySecondName = citiesAndFamilies.get(city);
            System.out.println(familySecondName);
        }

        reader.close();
    }
}
