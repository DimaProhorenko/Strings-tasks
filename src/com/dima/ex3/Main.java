package com.dima.ex3;

import com.dima.utils.Printer;

import java.util.Arrays;
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

//    String... values позволяет методу принимать не определенное количество аргументов, то есть
//    параметр name должен обязательно передан методу, а дальше можно передать 1,2,3 и более аргументов
//    которые будут собраны в массив строк values, также можно сразу передать массив строк который станет массивом values.
//    Если метод получит только обязательные аргументы, в данном случае name, то массив values будет пустым.
    public static int getNameCount(String name, String... values) {
        StringBuilder sb = new StringBuilder(String.join(" ", values));
        return countValueInString(name, sb.toString());
    }

//    Рекурсивный метод
//    Если значения value нет в строке str возвращает 0
//    Если есть, то метод вызывывает сам себя рекурсивно и заменяет первое совпадение value не учитывая регистр
//    Допустим метод вызвал сам себя 3 раза -> 1 + 1 + 0 = 2
    private static int countValueInString(String value, String str) {
        if (isValueInString(value, str)) {
            return 1 + countValueInString(value, str.replaceFirst("(?i)"+value, ""));
        }
        return 0;
    }

//    Проверяет 1 строку на равенство 2 без учитывания регистра
    private static boolean isValueInString(String value, String str) {
        return str.toLowerCase().contains(value.toLowerCase());
    }
}
