package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String[] record = fileScanner.nextLine().split(" ");
            String lastName = record[0];
            String firstName = record[1];
            String middleName = record[2];
            SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy");
            Date birthDate = null;
            try {
                birthDate = formatter.parse(record[3] + " " + record[4] + " " + record[5]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return new Person(firstName, middleName, lastName, birthDate);
        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close();
        }
    }
}
