package com.dima.ex2;

import com.dima.utils.Printer;

public class Main {
    public static void main(String[] args) {
        String[] values = {"orange", "plum", "tomato", "onion", "grape", "onion"};
        String[] withoutOnion = deleteWord("onion", values);
        Printer.printArray("Excercise 2 after removing onion", withoutOnion);
    }

    public static String[] deleteWord(String word, String... values) {
        return String.join(" ", values).replaceAll(word, "").split("\\s+");
    }
}
