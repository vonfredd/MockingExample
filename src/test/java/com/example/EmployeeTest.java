package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    private EmployeeRepository employeeRepository;
    private BankServiceImpl bankService;

    @BeforeEach
    void setUp(){
        employeeRepository = Mockito.mock(EmployeeRepository.class);
        bankService = new BankServiceImpl();
    }

    @Test
    void getId() {
    }

    @Test
    void setId() {
    }

    @Test
    void getSalary() {
    }

    @Test
    void setSalary() {
    }

    @Test
    void isPaid() {
    }

    @Test
    void setPaid() {
    }

    @Test
    void testToString() {
    }
}