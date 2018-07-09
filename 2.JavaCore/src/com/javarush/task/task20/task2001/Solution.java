package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File tempFile = File.createTempFile("/home/micredis/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2001/temp", null);
//            File tempFile = new File("/home/micredis/IdeaProjects/JavaRushVictoria/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2001/temp.tmp");
            OutputStream outputStream = new FileOutputStream(tempFile);
            InputStream inputStream = new FileInputStream(tempFile);

            Human ivanov = new Human("Ivanov", new Asset("house", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
//            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            outputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println("Ivanov was saved and then completely reconstructed from a file: " + ivanov.equals(somePerson));

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write(this.name);
            writer.newLine();
            if (this.assets.isEmpty()) {
                writer.write("0");
                writer.newLine();
            } else {
                writer.write(String.valueOf(this.assets.size()));
                writer.newLine();
                for (Asset asset : this.assets) {
                    writer.write(asset.getName());
                    writer.newLine();
                    writer.write(String.valueOf(asset.getPrice()));
                    writer.newLine();
                }
            }
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            if (reader.ready()) {
                this.name = reader.readLine();
                String sAssetsCount = reader.readLine();
                int assetsCount = (!"0".equals(sAssetsCount)) ? Integer.parseInt(sAssetsCount) : 0;
                for (int i = 0; i < assetsCount; i++) {
                    String assetName = reader.readLine();
                    double assetPrice = Double.parseDouble(reader.readLine());
                    this.assets.add(new Asset(assetName, assetPrice));
                }
            }
        }
    }
}
