package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.*;

/*
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() {
        //implement this method - реализуйте этот метод
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();
        try (FileInputStream fis = new FileInputStream(fileName)) {
            load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        for (Map.Entry<String, String> pair : Solution.properties.entrySet()) {
            prop.setProperty(pair.getKey(), pair.getValue());
        }
        prop.store(outputStream, null);
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        prop.load(inputStream);
        Enumeration<?> enumPropKeys = prop.propertyNames();
        while (enumPropKeys.hasMoreElements()) {
            String key = (String) enumPropKeys.nextElement();
            String value = prop.getProperty(key);
            Solution.properties.put(key, value);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        save properties map to a .properties file
        Solution.properties.put("key5", "value5");
        Solution.properties.put("key4", "value4");
        Solution.properties.put("key3", "value3");
        try (FileOutputStream fos = new FileOutputStream("/home/micredis/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2003/empty.properties")) {
            solution.save(fos);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        load from .properties file to the properties map
        solution.fillInPropertiesMap();

//        print properties map
        for (Map.Entry<String, String> entry : Solution.properties.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}