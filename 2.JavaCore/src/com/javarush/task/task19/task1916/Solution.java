package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        try (
                BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader origFileReader = new BufferedReader(new FileReader(fileNameReader.readLine()));
                BufferedReader modiFileReader = new BufferedReader(new FileReader(fileNameReader.readLine()))
        ) {
            List<String> origLines = readLinesIntoList(origFileReader);
            List<String> modiLines = readLinesIntoList(modiFileReader);
            int i = 0, j = 0;
            while (i < origLines.size() && j < modiLines.size()) {
                String orig = origLines.get(i);
                String nextOrig = (i + 1 < origLines.size()) ? origLines.get(i + 1) : "";
                String modi = modiLines.get(j);
                if (orig.equals(modi)) {
                    lines.add(new LineItem(Type.SAME, orig));
                    i++;
                    j++;
                } else if (nextOrig.equals(modi)) {
                    lines.add(new LineItem(Type.REMOVED, orig));
                    i++;
                } else {
                    lines.add(new LineItem(Type.ADDED, modi));
                    j++;
                }
            }
            while (i < origLines.size()) {
                String orig = origLines.get(i);
                lines.add(new LineItem(Type.REMOVED, orig));
                i++;
            }
            while (j < modiLines.size()) {
                String modi = modiLines.get(j);
                lines.add(new LineItem(Type.ADDED, modi));
                j++;
            }
//            for (LineItem lineItem : lines) {
//                System.out.println(lineItem.type + ": " + lineItem.line);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> readLinesIntoList(BufferedReader reader) throws IOException {
        List<String> list = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            list.add(line);
        }
        return list;
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
