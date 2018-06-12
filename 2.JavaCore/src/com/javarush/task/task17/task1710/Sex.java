package com.javarush.task.task17.task1710;

public enum Sex {
    MALE,
    FEMALE;

    @Override
    public String toString() {
        String result = null;
        switch (Sex.MALE) {
            case MALE: result = "м";
                break;
            case FEMALE: result = "ж";
                break;
            default:
                break;
        }
        return result;
    }
}
