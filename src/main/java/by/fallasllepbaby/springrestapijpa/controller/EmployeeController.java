package by.fallasllepbaby.springrestapijpa.controller;

import by.fallasllepbaby.springrestapijpa.model.Employee;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @GetMapping("/employees")
    public String getEmployees() {
        return "employee list";
    }

    @GetMapping("/employees/{id}")
    public String getEmployee(@PathVariable("id") Long id) {
        return "Emloyee id is " + id;
    }

    @PostMapping("/employees")
    public String saveEmployee(@RequestBody Employee employee) {
        return "saving the employee details to the database " + employee;
    }

    @DeleteMapping("/employees")
    public String deleteEmployee(@RequestParam("id") Long id) {
        return "You have deleted " + id + " id user";
    }
}
