package com.example;

import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

class EmployeesTest {
    private EmployeeRepository employeeRepository;
    private BankService bankService;

    @BeforeEach
    void setUp(){
        employeeRepository = mock(EmployeeRepository.class);
        bankService = spy(new BankServiceImpl());
        when(employeeRepository.findAll()).thenReturn(List.of(
                new Employee("100", 10_000.0),
                new Employee("101", 20_000.0),
                new Employee("102", 12_000.0),
                new Employee("103", 15_000.0)));
    }

    @Test
    @Description("Given a list of four employees, should return four")
    void givenAListOfFourEmployeesShouldReturnFour() {
        Employees employees = new Employees(employeeRepository,bankService);
        int number = employees.payEmployees();
        assertThat(number).isEqualTo(4);
    }

    @Test
    @Description("Given a call to pay method from implementation of bankService the test should verify it is called")
    void givenACallToPayMethodFromImplementationOfBankServiceTheTestShouldVerifyItIsCalled(){
        Employees employees = new Employees(employeeRepository,bankService);
        employees.payEmployees();
        verify(bankService,times(1)).pay("100",10000);
        verify(bankService,times(1)).pay("101",20000);
        verify(bankService,times(1)).pay("102",12000);
        verify(bankService,times(1)).pay("103",15000);
    }

    @Test
    @Description("isPaid should return false if employee throws exception")
    void givenAnEmployeeThatTriggerAnExceptionTheIsPaidOfThatEmployeeShouldBeFalse(){
        Employees employees = new Employees(employeeRepository,bankService);
        List<Employee> employeeList = employeeRepository.findAll();
        doThrow(new RuntimeException()).when(bankService).pay("102",12000);
        employees.payEmployees();
        assertThat(employeeList.get(1).isPaid()).isEqualTo(true);
        assertThat(employeeList.get(2).isPaid()).isEqualTo(false);
    }
}