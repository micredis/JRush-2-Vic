package com.javarush.task.task17.task1710;

import java.text.ParseException;

public enum Sex {
    MALE,
    FEMALE;

    @Override
    public String toString() {
        String result = null;
        switch (this) {
            case MALE: result = "м";
                break;
            case FEMALE: result = "ж";
                break;
            default:
                break;
        }
        return result;
    }

    public static Sex parseSex(String sex) throws ParseException {
        Sex result = null;
        switch (sex) {
            case "м": result = Sex.MALE;
                break;
            case "ж": result = Sex.FEMALE;
                break;
            default:
                throw new ParseException(sex, 0);
        }
        return result;
    }
}
