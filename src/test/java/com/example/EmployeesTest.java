package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class EmployeesTest {
    private EmployeeRepository employeeRepository;
    private BankService bankService;

    @BeforeEach
    void setUp(){
        employeeRepository = Mockito.mock(EmployeeRepository.class);
        bankService = Mockito.mock(BankService.class);
    }

    @Test
    void payEmployees() {
    }
}