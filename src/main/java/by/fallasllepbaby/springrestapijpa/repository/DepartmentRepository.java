package by.fallasllepbaby.springrestapijpa.repository;

import by.fallasllepbaby.springrestapijpa.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
