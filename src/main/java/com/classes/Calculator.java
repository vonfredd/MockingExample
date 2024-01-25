package com.classes;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Calculator {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        int sum = c.add("7,1000,5,3005");
    }
    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        char delimiter = ',';
        if (input.startsWith("//")) {
            delimiter = input.charAt(2);
            input = input.substring(4);
        }
        List<Integer> negativeNumberList = Stream.of(input.split("[\\n" + delimiter +"]")).mapToInt(Integer::parseInt).filter((e)-> e < 0).boxed().toList();
        if (negativeNumberList.size() > 0)
            throw new IllegalArgumentException("“negatives not allowed”" + negativeNumberList);

        return input.isEmpty() ? 0 : Stream.of(input.split("[\\n" + delimiter +"]")).mapToInt(Integer::parseInt).filter((e) -> e <= 1000).sum();
    }

}
