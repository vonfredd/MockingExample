package com.example;

import com.classes.Employee;
import com.classes.EmployeeRepositoryImpl;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryImplTest {

    @BeforeEach
    void setUp() {
        EmployeeRepositoryImpl.latestId = 100;
    }

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
        assertThrows(IllegalArgumentException.class, () -> new EmployeeRepositoryImpl(-35));
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
    @Description("Should update object and return true if object has new salary and same id")
    void shouldUpdateObjectAndReturnTrueIfObjectHasNewSalaryAndSameId() {
        EmployeeRepositoryImpl employeeRepositoryImpl = new EmployeeRepositoryImpl();
        employeeRepositoryImpl.save(new Employee("100", 10_000.0));
        employeeRepositoryImpl.save(new Employee("100", 20_000.0));
        List<Employee> empList = employeeRepositoryImpl.findAll();
        assertThat(empList.get(0).getSalary()).isEqualTo(20_000.0);
        assertThat(empList.get(0).getId()).isEqualTo("100");
    }

    @Test
    @Description("Should return true if list contains prepopulated employee ids")
    void shouldReturnTrueIfListContainsPrepopulatedEmployeeIds() {
        EmployeeRepositoryImpl employeeRepositoryImpl = new EmployeeRepositoryImpl(3);
        List<String> employeeIdList = employeeRepositoryImpl.findAll()
                .stream()
                .map(Employee::getId)
                .toList();
        assertThat(employeeIdList).contains("100", "101", "102");
    }

    @Test
    @DisplayName("Should throw exception if employee parameter is null")
    void shouldThrowExceptionIfEmployeeParameterIsNull(){
        EmployeeRepositoryImpl employeeRepositoryImpl = new EmployeeRepositoryImpl();

        assertThrows(NullPointerException.class,()-> {employeeRepositoryImpl.save(null);});
    }
}