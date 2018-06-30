package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return this.data.getCompany();
        }

        @Override
        public String getCountryName() {
            String countryCode = this.data.getCountryCode();
            return Solution.countries.get(countryCode);
        }

        @Override
        public String getName() {
            return (data.getContactLastName() + ", " + data.getContactFirstName());
        }

        @Override
        public String getPhoneNumber() {
            int countryCode = this.data.getCountryPhoneCode();
            int shortNumber = this.data.getPhoneNumber();
            String shortNumber10 = String.format("%010d", shortNumber);
            String sn1 = shortNumber10.substring(0, 3);
            String sn2 = shortNumber10.substring(3, 6);
            String sn3 = shortNumber10.substring(6, 8);
            String sn4 = shortNumber10.substring(8, 10);
            return String.format("+%d(%s)%s-%s-%s", countryCode, sn1, sn2, sn3, sn4);
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}