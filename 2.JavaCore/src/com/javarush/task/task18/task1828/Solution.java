package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private String fileName;
    {
        Scanner scanner = new Scanner(System.in);
        this.fileName = scanner.nextLine();
        scanner.close();
    }

    public static void main(String[] args) {
        if (args.length > 1) {
            new Solution().go(args);
        }
    }

    private void go(String[] args) {
        String id = args[1];
        switch (args[0]) {
            case "-u":
                if (args.length < 5)
                    break;
                updateRecord(id, args, this.fileName);
                break;
            case "-d":
                deleteRecord(id, this.fileName);
                break;
            default:
                break;
        }
    }

    private void updateRecord(String id, String[] args, String fileName) {
        String productName = args[2];
        String price = args[3];
        String quantity = args[4];
        int argLen = args.length;
        if (argLen > 5) {
            for (int i = 3; i < argLen - 2; i++) {
                productName += " ";
                productName += args[i];
            }
            price = args[argLen - 2];
            quantity = args[argLen - 1];
        }
        List<String> listFile = readFileToList(fileName);
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < listFile.size(); i++) {
                String record = listFile.get(i);
                String currentId = record.substring(0, 8).trim();
                if (!id.equals(currentId)) {
                    fileWriter.write(record);
                } else {
                    String updatedRecord = String.format("%-8s%-30.30s%-8.8s%-4.4s", id, productName, price, quantity);
                    fileWriter.write(updatedRecord);
                }
                if (i < listFile.size() - 1) {
                    fileWriter.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateRecordTempFile(String id, String[] args, String fileName) {
        String productName = args[2];
        String price = args[3];
        String quantity = args[4];
        int argLen = args.length;
        if (argLen > 5) {
            for (int i = 3; i < argLen - 2; i++) {
                productName += " ";
                productName += args[i];
            }
            price = args[argLen - 2];
            quantity = args[argLen - 1];
        }
        File origFile = new File(fileName);
        File tempFile = new File(fileName + ".tmp");
        try (BufferedReader fileReader = new BufferedReader(new FileReader(origFile))) {
            try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(tempFile))) {
                while (fileReader.ready()) {
                    String record = fileReader.readLine();
                    String currentId = record.substring(0, 8).trim();
                    if (!id.equals(currentId)) {
                        fileWriter.write(record);
                    } else {
                        String updatedRecord = String.format("%-8s%-30.30s%-8.8s%-4.4s", id, productName, price, quantity);
                        fileWriter.write(updatedRecord);
                    }
                    if (fileReader.ready()) {
                        fileWriter.newLine();
                    }
                }
            }
       } catch (IOException e) {
           e.printStackTrace();
       }
       if (origFile.exists() && tempFile.exists()) {
            tempFile.renameTo(origFile);
            tempFile.delete();
       }
    }

    private void deleteRecord(String id, String fileName) {
        List<String> listFile = readFileToList(fileName);
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < listFile.size(); i++) {
                String record = listFile.get(i);
                String currentId = record.substring(0, 8).trim();
                if (!id.equals(currentId)) {
                    fileWriter.write(record);
                    if (i < listFile.size() - 1) {
                        fileWriter.newLine();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteRecordTempFile(String id, String fileName) {
        File origFile = new File(fileName);
        File tempFile = new File(fileName + ".tmp");
        try (BufferedReader fileReader = new BufferedReader(new FileReader(origFile))) {
            try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(tempFile))) {
                while (fileReader.ready()) {
                    String record = fileReader.readLine();
                    String currentId = record.substring(0, 8).trim();
                    if (!id.equals(currentId)) {
                        fileWriter.write(record);
                        if (fileReader.ready()) {
                            fileWriter.newLine();
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (origFile.exists() && tempFile.exists()) {
            tempFile.renameTo(origFile);
            tempFile.delete();
        }
    }

    private List<String> readFileToList(String fileName) {
        List<String> listFile = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()) {
                listFile.add(fileReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listFile;
    }
}
