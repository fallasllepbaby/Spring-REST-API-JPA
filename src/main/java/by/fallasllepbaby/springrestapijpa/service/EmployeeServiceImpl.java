package by.fallasllepbaby.springrestapijpa.service;

import by.fallasllepbaby.springrestapijpa.model.Employee;
import by.fallasllepbaby.springrestapijpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository eRepository;

    @Override
    public List<Employee> getEmployees(int pageNumber, int pageSize) {
        Pageable pages = PageRequest.of(pageNumber, pageSize, Sort.Direction.DESC, "id");
        return eRepository.findAll(pages).getContent();
    }


    @Override
    public Employee getSingleEmployee(Long id) {
        Optional<Employee> employee = eRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }
        throw new RuntimeException("Employee is not found for the id " + id);
    }


    @Override
    public Employee updateEmployee(Employee employee) {
        return eRepository.save(employee);
    }

}
