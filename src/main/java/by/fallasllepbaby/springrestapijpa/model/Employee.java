package by.fallasllepbaby.springrestapijpa.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.ToString;
import lombok.Setter;
import lombok.Getter;

@Setter
@Getter
@ToString
public class Employee {
    private String name;
    private Long age;
    private String location;
    private String email;
    private String department;
}
