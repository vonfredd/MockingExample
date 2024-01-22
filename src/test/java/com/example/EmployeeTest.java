package com.example;

import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


class EmployeeTest {

    private Employee employee;
    @BeforeEach
    void setUp(){
        employee = new Employee("123",10_000.0);
    }

    @Test
    @Description("Given an employeeId, return true if the id retrieved is the same as the given id")
    void givenAnEmployeeIdAssertTrueIfTheIdRetrievedIsTheSameAsTheGivenId() {
       String id = employee.getId();
       assertThat("123").isEqualTo(id);
    }



    @Test
    @Description("Given a new id , return true if the employee id is equal to the new id ")
    void trueIfTheSetIdIsTheEmployeesNewId() {
        String newId = "124";
        employee.setId(newId);
        assertThat(employee.getId()).isEqualTo(newId);
    }

    @Test
    @Description("Given a salary of same amount as employee salary, getSalary should return true")
    void trueIfSalaryIsTheSameAsEmployeeSalary() {
        double salary = 10_000.0;
        assertThat(employee.getSalary()).isEqualTo(salary);
    }

    @Test
    @Description("Given a new salary value, expect employee salary to change to new salary")
    void trueIfNewSalaryIsEmployeeSalary() {
        double newSalary = 20_000.0;
        employee.setSalary(newSalary);
        assertThat(employee.getSalary()).isEqualTo(newSalary);
    }

    @Test
    @Description("Given an employee not been paid, return false")
    void givenAnEmployeeNotBeenPaidReturnFalse() {
        assertThat(employee.isPaid()).isEqualTo(false);
    }

    @Test
    @Description("Given an employee that has been paid, return true")
    void givenAnEmployeeThatHasBeenPaidReturnTrue() {
        employee.setPaid(true);
        assertThat(employee.isPaid()).isEqualTo(true);
    }

    @Test
    @Description("Given a string, expect employee presentation to match")
    void givenAStringExpectEmployeePresentationToMatch() {
        String presentation = "Employee [id=123, salary=10000.0]";
        assertThat(employee.toString()).isEqualTo(presentation);
    }
}