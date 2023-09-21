package by.fallasllepbaby.springrestapijpa.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import jakarta.persistence.*;
import lombok.ToString;
import lombok.Setter;
import lombok.Getter;

@Setter
@Getter
@ToString
@Entity
@Table(name = "tbl_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Long age;

    @Column(name = "location")
    private String location;

    @Column(name = "email")
    private String email;

    @Column(name = "department")
    private String department;

}
