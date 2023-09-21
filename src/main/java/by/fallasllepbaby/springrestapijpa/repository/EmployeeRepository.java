package by.fallasllepbaby.springrestapijpa.repository;

import by.fallasllepbaby.springrestapijpa.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
