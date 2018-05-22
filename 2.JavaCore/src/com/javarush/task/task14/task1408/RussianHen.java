package com.javarush.task.task14.task1408;

public class RussianHen extends Hen {
    private int eggsPerMonth = 18;

    @Override
    int getCountOfEggsPerMonth() {
        return this.eggsPerMonth;
    }

    @Override
    String getDescription() {
        return String.format("%s Моя страна - %s. Я несу %d яиц в месяц.",
                super.getDescription(),
                Country.RUSSIA,
                this.getCountOfEggsPerMonth());
    }
}
