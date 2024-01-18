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
    @Description("Given an employeeId, assertTrue if the id retrieved is the same as the given id")
    void givenAnEmployeeIdAssertTrueIfTheIdRetrievedIsTheSameAsTheGivenId() {
       String id = employee.getId();
       assertThat("123").isEqualTo(id);
    }

    @Test
    @Description("Given a new id , assert that the employee id is equal to the new id ")
    void trueIfTheSetIdIsTheEmployeesNewId() {
        String newId = "124";
        employee.setId(newId);
        assertThat(employee.getId()).isEqualTo(newId);
    }

    @Test
    @Description("True if salary is the same as employee salary")
    void trueIfSalaryIsTheSameAsEmployeeSalary() {
        double salary = 10_000.0;
        assertThat(employee.getSalary()).isEqualTo(salary);
    }

    @Test
    @Description("True if new salary is employee salary")
    void trueIfNewSalaryIsEmployeeSalary() {
        double newSalary = 20_000.0;
        employee.setSalary(newSalary);
        assertThat(employee.getSalary()).isEqualTo(newSalary);
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