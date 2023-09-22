package by.fallasllepbaby.springrestapijpa.model;

import by.fallasllepbaby.springrestapijpa.request.EmployeeRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

    @OneToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee(EmployeeRequest req) {
        this.name = req.getName();
    }

}
