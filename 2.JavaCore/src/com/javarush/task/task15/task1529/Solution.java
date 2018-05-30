package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    private static final String PLANE = "plane";
    private static final String HELICOPTER = "helicopter";

    public static void main(String[] args) {

    }
    
    static {
        //add your code here - добавьте код тут
        reset();
    }

    public static Flyable result;

    public static void reset() {
        //add your code here - добавьте код тут
        String flyingVehicle = "";
        int numOfPassengers = 0;
        try {
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(System.in));
            flyingVehicle = reader.readLine();
            switch (flyingVehicle) {
                case PLANE:
                    numOfPassengers = Integer.parseInt(reader.readLine());
                    result = new Plane(numOfPassengers);
                    break;
                case HELICOPTER:
                    result = new Helicopter();
                    break;
                default:
                    break;
            }
            reader.close();
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
    }
}
