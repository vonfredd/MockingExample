package com.example;

import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeRepositoryImplTest {

    @ParameterizedTest
    @Description("Returns true if list returns same size as parameter")
    @ValueSource(ints = {3, 7, 23, 10, 35})
    void returnsTrueIfListReturnsSameSizeAsParameter(int argument) {
        EmployeeRepositoryImpl employeeRepositoryImpl = new EmployeeRepositoryImpl(argument);
        List<Employee> list = employeeRepositoryImpl.findAll();
        assertThat(list.size()).isEqualTo(argument);
    }

    @Test
    @Description("Throws exception if pre populated constructor gets negative argument")
    void returnsFalseIfPrePopulatedConstructorGetsNegativeArgument() {
        assertThrows(IllegalArgumentException.class, () -> {
            new EmployeeRepositoryImpl(-35);
        });
    }


    @Test
    @Description("Return true if employee null id is set to next id")
    void returnTrueIfEmployeeNullIdIsSetToNextId() {
        EmployeeRepositoryImpl employeeRepositoryImpl = new EmployeeRepositoryImpl(2);
        Employee emp = new Employee(null, 20_000.0);
        emp = employeeRepositoryImpl.save(emp);
        assertThat(emp.getId()).isEqualTo("103");
    }

    @Test
    @Description("Validate true if employee argument has an id that already exist")
    void validateTrueIfEmployeeArgumenthasAnIdThatAlreadyExist(){

    }
}