package com.javarush.task.task20.task2004;

import java.io.*;

/* 
Читаем и пишем в файл статики
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

//            File your_file_name = File.createTempFile("your_file_name", null);
            File tempFile = new File("/home/micredis/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2004/saved.tmp");
            OutputStream outputStream = new FileOutputStream(tempFile);
            InputStream inputStream = new FileInputStream(tempFile);

            ClassWithStatic classWithStatic = new ClassWithStatic();
            classWithStatic.i = 3;
            classWithStatic.j = 4;
            classWithStatic.save(outputStream);
            outputStream.flush();

            ClassWithStatic loadedObject = new ClassWithStatic();
            loadedObject.staticString = "something";
            loadedObject.i = 6;
            loadedObject.j = 7;

            loadedObject.load(inputStream);
            //check here that classWithStatic object equals to loadedObject object - проверьте тут, что classWithStatic и loadedObject равны
            System.out.println("classWithStatic.equals(loadedObject) : " + classWithStatic.equals(loadedObject));
            //sure thing it's the same static String
            System.out.println("classWithStatic.staticString.equals(loadedObject.staticString) : "
                    + classWithStatic.staticString.equals(loadedObject.staticString));
            System.out.println("classWithStatic.i == loadedObject.i : " + (classWithStatic.i == loadedObject.i));
            System.out.println("classWithStatic.j == loadedObject.j : " + (classWithStatic.j == loadedObject.j));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class ClassWithStatic {
        public static String staticString = "it's a test static string";
        public int i;
        public int j;

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write(ClassWithStatic.staticString);
            writer.newLine();
            writer.write(String.valueOf(this.i));
            writer.newLine();
            writer.write(String.valueOf(this.j));
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            ClassWithStatic.staticString = reader.readLine();
            this.i = Integer.parseInt(reader.readLine());
            this.j = Integer.parseInt(reader.readLine());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ClassWithStatic that = (ClassWithStatic) o;

            if (i != that.i) return false;
            return j == that.j;

        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }
    }
}
