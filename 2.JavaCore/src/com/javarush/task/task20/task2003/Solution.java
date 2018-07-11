package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
        outputStream.write(("#" + new Date().toString()).getBytes());
        outputStream.write(System.lineSeparator().getBytes());
        for (Map.Entry<String, String> entry : Solution.properties.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            outputStream.write((key + " = " + value).getBytes());
            outputStream.write(System.lineSeparator().getBytes());
        }
        outputStream.flush();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            if (!line.startsWith("#") && !line.startsWith("!")) {
                int equalsSignIndex = line.indexOf("=");
                int colonIndex = line.indexOf(":");
                int delimiterIndex;
                if (equalsSignIndex > -1 && colonIndex > -1) {
                    delimiterIndex = (equalsSignIndex < colonIndex) ? equalsSignIndex : colonIndex;
                } else if (equalsSignIndex > -1) {
                    delimiterIndex = equalsSignIndex;
                } else {
                    delimiterIndex = colonIndex;
                }
                String key = line.substring(0, delimiterIndex).trim();
                String value = line.substring(delimiterIndex + 1).trim();
                if (value.endsWith("\\"))
                    value = value.substring(0, value.length() - 1) + reader.readLine().trim();
                Solution.properties.put(key, value);
            }
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
        try (FileInputStream fis = new FileInputStream("/home/micredis/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2003/test.properties")) {
            solution.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        print properties map
        for (Map.Entry<String, String> entry : Solution.properties.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}