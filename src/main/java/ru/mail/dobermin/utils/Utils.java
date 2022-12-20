package ru.mail.dobermin.utils;

public class Utils {

    public static double format(double input) {
        return Math.ceil(input * 100) / 100;
    }
}
