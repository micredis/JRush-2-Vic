package com.javarush.task.task20.task2026;

/*
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };
        byte[][] a3 = new byte[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 0, 1, 0},
                {0, 0, 1, 1, 1, 1, 0, 1, 0},
                {0, 0, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 0, 0, 0},
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Expected: 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Expected: 4");
        int count3 = getRectangleCount(a3);
        System.out.println("count = " + count3 + ". Expected: 5");
    }

    public static int getRectangleCount(byte[][] a) {
        byte[][] arr = new byte[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            System.arraycopy(a[i], 0, arr[i], 0, a[i].length);
        }

        int count = 0;
        byte[] prevRow = new byte[arr[0].length];
        for (byte[] row : arr) {
            boolean isJStarted = false;
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 1) {
                    if (!isJStarted && prevRow[j] != 1) {
                        isJStarted = true;
                        count++;
                    }
                    boolean isJEdge = j + 1 == row.length || row[j + 1] == 0;
                    if (isJEdge) {
                        isJStarted = false;
                    }
                } else {
                    if (isJStarted) {
                        isJStarted = false;
                    }
                }
                prevRow[j] = row[j];
            }
        }
        return count;
    }
}
