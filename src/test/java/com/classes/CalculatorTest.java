package com.classes;

import com.sun.jdi.Value;
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
    @CsvSource(value = {"1,2"}, delimiter = (';'))
    void returnsSumOfTwoNumbers(String input) {
        int sum = calculator.add(input);
        assertThat(sum).isEqualTo(3);
    }

    @Test
    @DisplayName("Empty string should return 0")
    void emptyStringReturns0() {
        int sum = calculator.add("");
        assertThat(sum).isEqualTo(0);
    }

    @Test
    @DisplayName("Single number should return itself")
    void singleNumberShouldReturnItself() {
        int sum = calculator.add("9");
        assertThat(sum).isEqualTo(9);
    }

    @ParameterizedTest
    @DisplayName("Add method handles unknown amount of numbers")
    @CsvSource(value = {"1,2;3", "2;2", "1,2,3,4,5,6,7,8,9;45"}, delimiter = (';'))
    void addMethodHandlesUnknownAmountOfNumbers(String input, int expectedSum) {
        int sum = calculator.add(input);
        assertThat(sum).isEqualTo(expectedSum);
    }

    @Test
    @DisplayName("Should handle newlines between numbers")
    void shouldHandleNewlinesBetweenNumbers() {
        int sum = calculator.add("1\n2,3");
        assertThat(sum).isEqualTo(6);
    }

    @Test
    @DisplayName("Supports different delimiters")
    void supportsDifferentDelimiters() {
        int sum = calculator.add("//;\n1;2");
        assertThat(sum).isEqualTo(3);
    }

    @Test
    @DisplayName("Input negative numbers throws an exception")
    void inputNegativeNumbersThrowsAnException() {
        assertThrows(IllegalArgumentException.class, () -> calculator.add("1,2,-3,7"));
    }

    @ParameterizedTest
    @DisplayName("Should not throw exception if 0 is used as parameter")
    @ValueSource(strings = {"1,1000,0"})
    void shouldNotThrowExceptionIf0IsUsedAsParameter(String input){
        assertDoesNotThrow(() -> calculator.add(input));
    }

    @Test
    @DisplayName("Ignore to add numbers bigger than 1000")
    void ignoreToAddNumbersBiggerThan1000() {
        int sum = calculator.add("2,1001");
        assertThat(sum).isEqualTo(2);
    }

    @ParameterizedTest
    @DisplayName("Add values that is equal to 1000")
    @ValueSource(strings = {"1,5,1000"})
    void addValuesThatIsEqualTo1000(String input){
        int sum = calculator.add(input);
        assertThat(sum).isEqualTo(1006);
    }

    @Test
    @DisplayName("Delimiters can be of any length")
    void delimitersCanBeOfAnyLength() {
        int number = calculator.add("//[***]\n1***2***3");
        assertThat(number).isEqualTo(6);
    }

    @Test
    @DisplayName("Add can use multiple delimiters")
    void addCanUseMultipleDelimiters() {
        int number = calculator.add("//[*][%]\n1*2%3");
        assertThat(number).isEqualTo(6);
    }

}
