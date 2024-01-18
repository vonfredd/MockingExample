package com.example;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;



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