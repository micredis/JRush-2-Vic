package com.javarush.task.task20.task2008;

import java.io.*;

/* 
Как сериализовать Singleton?
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Singleton instance = Singleton.getInstance();

        ByteArrayOutputStream byteArrayOutputStream = serializeSingletonInstance(instance);

        Singleton singleton = deserializeSingletonInstance(byteArrayOutputStream);
        Singleton singleton1 = deserializeSingletonInstance(byteArrayOutputStream);

        System.out.println("Проверка ourInstance : " + singleton.getInstance());
        System.out.println("Проверка ourInstance : " + singleton1.getInstance());
        System.out.println("=========================================================");
        System.out.println("Проверка singleton : " + singleton);
        System.out.println("Проверка singleton1 : " + singleton1);
    }

    public static ByteArrayOutputStream serializeSingletonInstance(Singleton instance) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream);
        oos.writeObject(instance);
        oos.close();

        return byteArrayOutputStream;
    }

    public static Singleton deserializeSingletonInstance(ByteArrayOutputStream byteArrayOutputStream) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

        ObjectInputStream ois = new ObjectInputStream(byteArrayInputStream);
        Singleton singleton = (Singleton) ois.readObject();
        ois.close();

        return singleton;
    }

    public static class Singleton implements Serializable {
        private static Singleton ourInstance;

        public static Singleton getInstance() {
            if (ourInstance == null) {
                ourInstance = new Singleton();
            }
            return ourInstance;
        }

        private Singleton() {
        }


//        Serialization: Understand 'readResolve'
//        https://www.javalobby.org/java/forums/t17491.html
// Now through the serializable tools, someone can write a singleton instance to disk, and then read it back up, effectively
// getting a new instance. Even though the constructor is private, the serializable tools have special access to create instances
// of a class regardless. Serialization has a special hook it uses - a private method on the class being instantiated called
// readResolve() - which is meant to supply a 'hook' for a class developer to ensure that they have a say in what object is
// returned by serialization. Oddly enough, readResolve() is not static, but is instead invoked on the new instance just created
// by the serialization.

//        Classes that need to define a replacement when an instance of it is read from the stream should implement this special
//        method with the exact signature:
        private Object readResolve() {
            return ourInstance;
        }
    }
}
