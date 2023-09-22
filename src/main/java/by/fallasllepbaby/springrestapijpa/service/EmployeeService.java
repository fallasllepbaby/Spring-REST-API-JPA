package by.fallasllepbaby.springrestapijpa.service;

import by.fallasllepbaby.springrestapijpa.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees(int pageNumber, int pageSize);


    Employee getSingleEmployee(Long id);


    Employee updateEmployee(Employee employee);

}
