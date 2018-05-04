package com.javarush.task.task09.task0918;

/* 
Все свои, даже исключения
*/

import java.io.EOFException;
import java.net.SocketException;

public class Solution {
    public static void main(String[] args) {
    }
    
    static class MyException extends EOFException {
    }

    static class MyException2 extends SocketException {
    }

    static class MyException3 extends NullPointerException {
    }

    static class MyException4 extends IndexOutOfBoundsException {
    }
}

