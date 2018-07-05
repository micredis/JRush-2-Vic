package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter implements AutoCloseable {
    private FileWriter fileWriter;

    public FileConsoleWriter(String fileName) throws IOException {
        this.fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        this.fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        this.fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        this.fileWriter = new FileWriter(fd);
    }

    public static void main(String[] args) {
//        try (FileConsoleWriter fileConsoleWriter = new FileConsoleWriter("/home/micredis/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1917/out.txt")) {
//            String test = "Here we are";
//            String test2 = "And here we are again";
//            char[] buf = test2.toCharArray();
//            fileConsoleWriter.write(33);
//            fileConsoleWriter.write(System.lineSeparator());
//            fileConsoleWriter.write(test, 5, 2);
//            fileConsoleWriter.write(System.lineSeparator());
//            fileConsoleWriter.write(test);
//            fileConsoleWriter.write(System.lineSeparator());
//            fileConsoleWriter.write(buf);
//            fileConsoleWriter.write(System.lineSeparator());
//            fileConsoleWriter.write(buf, 4, 4);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        this.fileWriter.write(cbuf, off, len);
        System.out.print(String.valueOf(cbuf, off, len));
    }

    public void write(int c) throws IOException {
        this.fileWriter.write(c);
        System.out.print(c);
    }

    public void write(String str) throws IOException {
        this.fileWriter.write(str);
        System.out.print(str);
    }

    public void write(String str, int off, int len) throws IOException {
        this.fileWriter.write(str, off, len);
        System.out.print(str.substring(off, off + len));
    }

    public void write(char[] cbuf) throws IOException {
        this.fileWriter.write(cbuf);
        System.out.print(String.valueOf(cbuf));
    }

    public void close() throws IOException {
        this.fileWriter.close();
    }
}
