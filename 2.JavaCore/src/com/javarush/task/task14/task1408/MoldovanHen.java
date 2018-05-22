package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen {
    private int eggsPerMonth = 16;

    @Override
    int getCountOfEggsPerMonth() {
        return this.eggsPerMonth;
    }

    @Override
    String getDescription() {
        return String.format("%s Моя страна - %s. Я несу %d яиц в месяц.",
                super.getDescription(),
                Country.MOLDOVA,
                this.getCountOfEggsPerMonth());
    }
}
