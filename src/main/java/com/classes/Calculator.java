package com.classes;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Calculator {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        c.add("//;\n1;2");
    }
    public int add(String input) {
        char delimiter = ',';
        if (input.startsWith("//")) {
            delimiter = input.charAt(2);
            input = input.substring(4);
        }
        return input.isEmpty() ? 0 : Stream.of(input.split("[\\n" + delimiter +"]")).mapToInt(Integer::parseInt).sum();
    }
}
