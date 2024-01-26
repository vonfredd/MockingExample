package com.classes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Calculator {
    public int add(String input) {

        if (input.isEmpty()) {
            return 0;
        }

        String delimiter = ",";
        if (input.startsWith("//[")) {
            delimiter = "["+
                    List.of(input.split("\\n"))
                            .getFirst()
                            .replace("/","")
                            .replace("]","[")
                            .replace("[","")
                    + "]";

            input = Arrays.stream(input.split("\\n"))
                    .toList()
                    .getLast();
        } else if (input.startsWith("//")) {
            delimiter = String.valueOf(input.charAt(2));
            input = input.substring(4);
        }

        List<Integer> negativeNumberList = Stream.of(input.split("\\*+|\\n|" + delimiter)).mapToInt(Integer::parseInt).filter(e -> e < 0).boxed().toList();
        if (!negativeNumberList.isEmpty())
            throw new IllegalArgumentException("“negatives not allowed”" + negativeNumberList);

        return Stream.of(input.split("\\*+|\\n|" + delimiter)).mapToInt(Integer::parseInt).filter(e -> e <= 1000).sum();
    }

}
