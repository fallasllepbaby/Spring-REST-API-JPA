package by.fallasllepbaby.springrestapijpa.service;

import by.fallasllepbaby.springrestapijpa.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static List<Employee> list = new ArrayList<>();

    static {
        Employee e = new Employee();
        e.setName("Bushan");
        e.setAge(28L);
        e.setDepartment("IT");
        e.setEmail("bushan@gmail.com");
        e.setLocation("India");
        list.add(e);

        e = new Employee();
        e.setName("Bharath");
        e.setAge(32L);
        e.setDepartment("Textile");
        e.setEmail("bharath@gmail.com");
        e.setLocation("Australia");
        list.add(e);
    }
    @Override
    public List<Employee> getEmployees() {
        return list;
    }
}
