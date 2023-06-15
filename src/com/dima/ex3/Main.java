package com.dima.ex3;

import com.dima.utils.Printer;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static String[] names = {"Bob", "Alice", "Tom", "Lucy", "Bob", "Lisa"};

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        while(true) {
            String input = getNameFromUser();
            if ("qQ".contains(input)) {
                break;
            }
            printNamesCount(input, getNameCount(input, names));
        }
    }

    public static String getNameFromUser() {
        System.out.println("Enter name to search for: (q to quit)");
        return scanner.nextLine();
    }


    public static void printNamesCount(String name, int count) {
        if (count == 0) {
            Printer.printHeader("%s was not found".formatted(name));
        } else {
            Printer.printHeader("%s occurs %d times".formatted(name, count));
        }
    }

    public static int getNameCount(String name, String... values) {
        StringBuilder sb = new StringBuilder(String.join(" ", values));
        return countValueInString(name, sb.toString());
    }

    private static int countValueInString(String value, String str) {
        if (isValueInString(value, str)) {
            return 1 + countValueInString(value, str.replaceFirst("(?i)"+value, ""));
        }
        return 0;
    }
    private static boolean isValueInString(String value, String str) {
        return str.toLowerCase().contains(value.toLowerCase());
    }
}
