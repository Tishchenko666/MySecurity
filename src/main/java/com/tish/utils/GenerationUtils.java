package com.tish.utils;

public class GenerationUtils {

    public static String passGenerator(int length) {
        String pass = "";
        char c;
        for (int i = 0; i < length; i++) {
            c = (char) ((int) (Math.random() * 33 + 94));
            pass = pass.concat(String.valueOf(c));
        }
        return pass;
    }

    public static String pinGenerator() {
        return String.valueOf((int) (Math.random() * 9000 + 1000));
    }
}
