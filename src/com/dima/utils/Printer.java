package com.dima.utils;

public abstract class Printer {
    public static void printHeader(String header, String delimeter) {
        System.out.println(delimeter.repeat(header.length()));
        System.out.println(header);
        System.out.println(delimeter.repeat(header.length()));
    }

    public static void printHeader(String header) {
        printHeader(header, "-");
    }

    public static <T> void printArray(String header, T[] arr) {
        printHeader(header);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + " " + arr[i]);
        }
    }
}
