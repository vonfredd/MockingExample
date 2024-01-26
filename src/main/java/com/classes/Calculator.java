package com.classes;

import java.awt.*;
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
        int sum = c.add("1,2,3,4,5,6,7,8,9");
    }
    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String delimiter = ",";
        if(input.startsWith("//[")){
            delimiter = input.substring(3,input.indexOf(']'));
            List<String> splitInput = List.of(input.split("\\n"));
            input = splitInput.getLast();
        }
        else if (input.startsWith("//")) {
            delimiter = String.valueOf(input.charAt(2));
            input = input.substring(4);
        }

        if (delimiter.charAt(0) == '*'){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < delimiter.length(); i++) {
                sb.append("\\" + delimiter.charAt(i));
            }
            delimiter = String.valueOf(sb);
        }

        List<Integer> negativeNumberList = Stream.of(input.split("\\*+|\\n|"+delimiter)).mapToInt(Integer::parseInt).filter((e)-> e < 0).boxed().toList();
        if (negativeNumberList.size() > 0)
            throw new IllegalArgumentException("“negatives not allowed”" + negativeNumberList);

        return input.isEmpty() ? 0 : Stream.of(input.split("\\*+|\\n|"+delimiter)).mapToInt(Integer::parseInt).filter((e) -> e <= 1000).sum();
    }

}
