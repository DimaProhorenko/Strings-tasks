package com.dima.ex1;

import java.util.Arrays;

import com.dima.utils.Printer;

public class Main {
    public static void main(String[] args) {
        String[] values = {"brange", "plum", "tomato", "onibn", "grape"};
        String[] fixedVals = changeBToO(values);
        Printer.printArray("Excercise 1 values", values);
        Printer.printArray("Excercise 1 fixedValues",fixedVals);
    }

//  Doesn't modify passed array
    public static String[] changeBToO(String[] vals) {
        return Arrays.stream(vals).map(el -> el.replace('b', 'o')).toArray(String[]::new);
    }
}
