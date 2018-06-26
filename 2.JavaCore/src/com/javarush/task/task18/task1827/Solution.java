package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    private String fileName;
    private int id;
    private String productName = "";
    private double price;
    private String quantity;

    public static void main(String[] args) throws Exception {
        if (args.length == 0) return;
        if (!"-c".equals(args[0])) return;
        new Solution().go(args);
    }

    private void go(String[] args) {
        this.fileName = readFileName();
        initFields(args);
        String record;
        if (this.id == 1) {
            record = String.format(
                    "%-8d%-30.30s%-8.2f%-4.4s",
                    this.id,
                    this.productName,
                    this.price,
                    this.quantity
            );
        } else {
            record = String.format(
                    "%n%-8d%-30.30s%-8.2f%-4.4s",
                    this.id,
                    this.productName,
                    this.price,
                    this.quantity
            );
        }
        addRecord(fileName, record);
    }

    private String readFileName() {
        String fileName = "";
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext())
            fileName = scanner.nextLine();
        scanner.close();
        return fileName;
    }

    private void initFields(String[] args) {
        // -c Toolbox and a horse with a quite big nose 123.9 5
        this.id = getLastID(fileName) + 1;
        int i;
        for (i = 1;
             i < args.length - 2 && this.productName.length() < 30;
             i++) {
            this.productName += args[i];
            this.productName += " ";
        }
        this.productName = this.productName.substring(0, 30);
        this.price = Double.parseDouble(args[args.length - 2]);
        this.quantity = args[args.length - 1];
    }

    private int getLastID(String fileName) {
        int id = 0;
        BufferedReader fileReader;
        try (FileInputStream fis = new FileInputStream(fileName)) {
            int estFileSize = fis.available();
            if (estFileSize > 3000) {
                fis.skip(estFileSize - (estFileSize * 95) / 100);
            }
            fileReader = new BufferedReader(new InputStreamReader(fis));
            String lastLine = "";
            while (fileReader.ready()) {
                lastLine = fileReader.readLine();
            }
            id = Integer.parseInt(lastLine.substring(0, 8));
            fileReader.close();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return id;
    }

    private void addRecord(String fileName, String record) {
        try (FileOutputStream fos = new FileOutputStream(fileName, true)) {
            fos.write(record.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
