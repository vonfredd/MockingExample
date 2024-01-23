package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final List<Employee> employeeList = new ArrayList<>();
    private static int latestId = 100;


    @Override
    public List<Employee> findAll() {
        return List.copyOf(employeeList);
    }

    @Override
    public Employee save(Employee e) {
        if (e.getId() == null) {
            e.setId(String.valueOf(++latestId));
            employeeList.add(e);
            return e;
        }

        boolean isFound = false;

        for (int i = 0; i < employeeList.size(); i++) {
            if (e.getId().equals(employeeList.get(i).getId())) {
                employeeList.set(i, e);
                isFound = true;
                break;
            }
        }
        if (!isFound)
            employeeList.add(e);
        return e;
    }
}
