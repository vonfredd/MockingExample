package com.classes;

import java.util.stream.Stream;

public class Calculator {
    public int add(String input) {
        return input.isEmpty() ? 0 : Stream.of(input.split("[\\n,]")).mapToInt(Integer::parseInt).sum();
    }
}
