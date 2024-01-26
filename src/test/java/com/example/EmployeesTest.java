package com.example;

import com.classes.BankService;
import com.classes.Employee;
import com.classes.EmployeeRepository;
import com.classes.Employees;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

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
    @Description("Given a call to pay method from implementation of bankService the test should verify it is called")
    void givenACallToPayMethodFromImplementationOfBankServiceTheTestShouldVerifyItIsCalled(){
        Employees employees = new Employees(employeeRepository,bankService);
        int number = employees.payEmployees();
        assertThat(number).isEqualTo(4);
    }

    @Test
    @DisplayName("Should return true if only three employees was paid after one triggered exception")
    void shouldReturnTrueIfOnlyThreeEmployeesWasPaidAfterOneTriggeredException(){
        BankService bankService1 = mock(BankServiceImpl.class);
        Employees employees = new Employees(employeeRepository,bankService1);
        doThrow(RuntimeException.class).when(bankService1).pay("100", 10_000.0);
        int sum = employees.payEmployees();
        assertEquals(3,sum);
    }

    @Test
    @DisplayName("Returns true if employee was paid")
    void returnsTrueIfEmployeeWasPaid(){
        Employees employees = new Employees(employeeRepository,bankService);
        employees.payEmployees();
        assertThat(employeeRepository.findAll()).extracting(Employee::isPaid).allMatch(isTrue -> isTrue);
    }

    @Test
    @DisplayName("Returns true if employee.isPaid is false after payEmployee() call")
    void returnsTrueIfEmployeeIsPaidIsFalseAfterPayEmployeeCall(){
        BankService bankService1 = mock(BankServiceImpl.class);
        Employees employees = new Employees(employeeRepository,bankService1);
        employees.payEmployees();
        doThrow(RuntimeException.class).when(bankService1).pay("100", 10_000.0);
        employees.payEmployees();
        assertFalse(employeeRepository.findAll().getFirst().isPaid());
    }
}