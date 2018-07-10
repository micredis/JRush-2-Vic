package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
//            File tempFile = File.createTempFile("JR_users", null);
            File tempFile = new File("/home/micredis/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2002/JR_users.tmp");
            OutputStream outputStream = new FileOutputStream(tempFile);
            InputStream inputStream = new FileInputStream(tempFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User josh = new User();
            josh.setFirstName("Joshua");
            josh.setLastName("Palmer");
            josh.setBirthDate(new Date(1998, 4, 20));
            josh.setMale(true);
            josh.setCountry(User.Country.UKRAINE);
            User justin = new User();
            justin.setFirstName("Justin");
            justin.setLastName("Palmer");
            justin.setBirthDate(new Date(2000, 0, 15));
            justin.setMale(true);
            justin.setCountry(User.Country.RUSSIA);
            javaRush.users.add(josh);
            javaRush.users.add(justin);

            JavaRush javaRush2 = new JavaRush();
            User linda = new User();
            linda.setFirstName("Linda");
            linda.setLastName("Spalding");
            linda.setBirthDate(new Date(1960, 7, 9));
            linda.setMale(false);
            linda.setCountry(User.Country.OTHER);
            javaRush2.users.add(linda);

            javaRush.save(outputStream);
            javaRush2.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
//            JavaRush loadedObject2 = new JavaRush();
            loadedObject.load(inputStream);
//            loadedObject2.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println("The first out of two JavaRush objects that were saved in a .tmp file is recovered successfully: "
                    + javaRush.equals(loadedObject));
//            System.out.println("JavaRush objects that were saved and then recovered from a file are all the same: "
//                    + javaRush.equals(loadedObject) + " && " + javaRush2.equals(loadedObject2) + " : "
//                    + String.valueOf(javaRush.equals(loadedObject) && javaRush2.equals(loadedObject2)).toUpperCase());

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write("new JavaRush object");
            writer.newLine();
            int usersCount = this.users.size();
            writer.write(String.valueOf(usersCount));
            writer.newLine();
            for (User user : users) {
                writer.write(user.getFirstName());
                writer.newLine();
                writer.write(user.getLastName());
                writer.newLine();
                writer.write(String.valueOf(user.getBirthDate().getTime()));
                writer.newLine();
                writer.write(user.isMale() ? "m" : "f");
                writer.newLine();
                writer.write(user.getCountry().getDisplayedName());
                writer.newLine();
            }
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null && !"new JavaRush object".equals(line)) {
            }
            int usersCount = Integer.parseInt(reader.readLine());
            for (int i = 0; i < usersCount; i++) {
                String firstName = reader.readLine();
                String lastName = reader.readLine();
                Date birthDate = new Date();
                birthDate.setTime(Long.valueOf(reader.readLine()));
                boolean isMale = "m".equals(reader.readLine());
                String sCountry = reader.readLine();
                User.Country country = ("Ukraine".equals(sCountry)) ? User.Country.UKRAINE :
                        ("Russia".equals(sCountry)) ? User.Country.RUSSIA : User.Country.OTHER;
                User user = new User();
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setBirthDate(birthDate);
                user.setMale(isMale);
                user.setCountry(country);
                this.users.add(user);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
