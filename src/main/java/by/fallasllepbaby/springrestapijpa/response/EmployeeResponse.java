package by.fallasllepbaby.springrestapijpa.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class EmployeeResponse {
    private Long id;
    private String employeeName;
    private List<String> department;
}
