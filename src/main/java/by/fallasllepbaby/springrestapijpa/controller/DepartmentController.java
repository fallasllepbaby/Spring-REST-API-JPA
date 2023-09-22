package by.fallasllepbaby.springrestapijpa.controller;

import by.fallasllepbaby.springrestapijpa.model.Department;
import by.fallasllepbaby.springrestapijpa.repository.DepartmentRepository;
import by.fallasllepbaby.springrestapijpa.response.DepartmentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

public class DepartmentController {

    @Autowired
    private DepartmentRepository dRepo;

    @GetMapping("/departments")
    public List<DepartmentResponse> getDepartments() {
        List<Department> depts = dRepo.findAll();
        List<DepartmentResponse> list = new ArrayList<>();
        depts.forEach(d -> {
            DepartmentResponse dResponse = new DepartmentResponse();
            dResponse.setDepartmentName(d.getName());
            dResponse.setId(d.getId());
            dResponse.setEmployeeName(d.getEmployee().getName());
            list.add(dResponse);
        });
        return list;
    }
}
