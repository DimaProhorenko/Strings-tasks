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

//    Тут я подумал что метод printArray может выводить в консоль не только массивы строк,
//    но и других типов не включая примитивные типы
//    Чтобы для каждого типа не писать отдельный метод использовал generics
//    <T> сигнализирует компилятору, что метод будет работать с generic типом
//    другими словами компилятор еще не знает какой тип будет использован
//    Также может быть <T extends ClassName(Interface)
//    Это значит, что тип который  будет использоваться должен быть сабклассом Classname
//    или имплементировать Interface
//    В данном контексте extends может значить extends или implements

    public static <T> void printArray(String header, T[] arr) {
        printHeader(header);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + 1 + " " + arr[i]);
        }
    }
}
