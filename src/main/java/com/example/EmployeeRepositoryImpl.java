package com.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository{

    private final List<Employee> employeeList = new ArrayList<>();
    @Override
    public List<Employee> findAll() {
        return List.copyOf(employeeList);
    }

    @Override
    public Employee save(Employee e) {
        return e;
    }
}
