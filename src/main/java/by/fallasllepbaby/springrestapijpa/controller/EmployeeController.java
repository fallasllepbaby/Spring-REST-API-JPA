package by.fallasllepbaby.springrestapijpa.controller;

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

    @DeleteMapping("/employees")
    public String deleteEmployee(@RequestParam("id") Long id) {
        return "You have deleted " + id + " id user";
    }
}
