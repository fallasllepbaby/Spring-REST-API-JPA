package by.fallasllepbaby.springrestapijpa.model;

import by.fallasllepbaby.springrestapijpa.request.EmployeeRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
@Entity
@Table(name = "tbl_employee")
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    /*@OneToOne
    @JoinColumn(name = "department_id")
    private Department department;*/

    @OneToMany(mappedBy = "employee")
    private List<Department> departments;

    public Employee(EmployeeRequest req) {
        this.name = req.getName();
    }

}
