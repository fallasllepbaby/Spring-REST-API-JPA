package by.fallasllepbaby.springrestapijpa.controller;

import by.fallasllepbaby.springrestapijpa.model.Department;
import by.fallasllepbaby.springrestapijpa.model.Employee;
import by.fallasllepbaby.springrestapijpa.repository.DepartmentRepository;
import by.fallasllepbaby.springrestapijpa.repository.EmployeeRepository;
import by.fallasllepbaby.springrestapijpa.request.EmployeeRequest;
import by.fallasllepbaby.springrestapijpa.response.DepartmentResponse;
import by.fallasllepbaby.springrestapijpa.response.EmployeeResponse;
import by.fallasllepbaby.springrestapijpa.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService eService;

    @Autowired
    private EmployeeRepository eRepo;

    @Autowired
    private DepartmentRepository dRepo;

    /*@GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
        return new ResponseEntity<List<Employee>>(eService.getEmployees(pageNumber, pageSize), HttpStatus.OK);
    }*/

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeResponse>> getEmployees() {
        List<Employee> list = eRepo.findAll();
        List<EmployeeResponse> responseList = new ArrayList<>();
        list.forEach(e -> {
            EmployeeResponse eResponse = new EmployeeResponse();
            eResponse.setId(e.getId());
            eResponse.setEmployeeName(e.getName());
            List<String> depts = new ArrayList<>();
            for (Department d : e.getDepartments()) {
                depts.add(d.getName());
            }
            eResponse.setDepartment(depts);
            responseList.add(eResponse);
        });
        return new ResponseEntity<List<EmployeeResponse>>(responseList, HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) {
        return new ResponseEntity<Employee>(eService.getSingleEmployee(id), HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<String> saveEmployee(@Valid @RequestBody EmployeeRequest eRequest) {
         Employee employee = new Employee(eRequest);
         employee = eRepo.save(employee);

         for (String s : eRequest.getDepartment()) {
             Department d = new Department();
             d.setName(s);
             d.setEmployee(employee);

             dRepo.save(d);
         }
         return new ResponseEntity<String>("Record saved successfully", HttpStatus.CREATED);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
        return new ResponseEntity<Employee>(eService.updateEmployee(employee), HttpStatus.OK);
    }

    @DeleteMapping("/employees")
    public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam("id") Long id) {
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }



}
