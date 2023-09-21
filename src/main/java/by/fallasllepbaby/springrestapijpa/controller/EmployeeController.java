package by.fallasllepbaby.springrestapijpa.controller;

import by.fallasllepbaby.springrestapijpa.model.Employee;
import by.fallasllepbaby.springrestapijpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService eService;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return eService.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable("id") Long id) {
        return eService.getSingleEmployee(id);
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return eService.saveEmployee(employee);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        System.out.println("updating employee data for the id " + id);
        return employee;
    }

    @DeleteMapping("/employees")
    public void deleteEmployee(@RequestParam("id") Long id) {
        eService.deleteEmployee(id);
    }
}
