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
    @Description("True if the set id is the employees new id")
    void trueIfTheSetIdIsTheEmployeesNewId() {
        String newId = "124";
        employee.setId(newId);
        assertThat(newId).isEqualTo(employee.getId());
    }

    @Test
    @Description("True if salary is the same as employee salary")
    void trueIfSalaryIsTheSameAsEmployeeSalary() {
        double salary = 10_000.0;
        assertThat(employee.getSalary()).isEqualTo(salary);
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