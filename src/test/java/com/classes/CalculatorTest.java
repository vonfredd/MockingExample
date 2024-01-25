package com.classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator = new Calculator();

    @ParameterizedTest
    @DisplayName("Returns sum of two numbers")
    @CsvSource (value = {"1,2"}, delimiter = (';'))
    void returnsSumOfTwoNumbers(String input){
        int sum = calculator.add(input);
        assertThat(sum).isEqualTo(3);
    }

    @Test
    @DisplayName("Empty string should return 0")
    void emptyStringReturns0(){
        int sum = calculator.add("");
        assertThat(sum).isEqualTo(0);
    }

    @Test
    @DisplayName("Single number should return itself")
    void singleNumberShouldReturnItself(){
        int sum = calculator.add("9");
        assertThat(sum).isEqualTo(9);
    }
}