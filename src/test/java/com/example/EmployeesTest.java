package com.example;

import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;

class EmployeesTest {
    private EmployeeRepository employeeRepository;
    private BankService bankService;

    @BeforeEach
    void setUp(){
        employeeRepository = mock(EmployeeRepository.class);
        bankService = new BankServiceImpl();
        when(employeeRepository.findAll()).thenReturn(List.of(
                new Employee("100", 10_000.0),
                new Employee("101", 20_000.0),
                new Employee("102", 12_000.0),
                new Employee("103", 15_000.0)));
    }

    @Test
    @Description("Given")
    void payEmployees() {
        Employees employees = new Employees(employeeRepository,bankService);

    }
}