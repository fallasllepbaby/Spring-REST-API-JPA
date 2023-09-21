package by.fallasllepbaby.springrestapijpa.service;

import by.fallasllepbaby.springrestapijpa.model.Employee;
import by.fallasllepbaby.springrestapijpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository eRepository;

    @Override
    public List<Employee> getEmployees() {
        return eRepository.findAll();
    }
}
