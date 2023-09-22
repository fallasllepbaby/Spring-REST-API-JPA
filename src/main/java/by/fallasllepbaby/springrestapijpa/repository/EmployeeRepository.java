package by.fallasllepbaby.springrestapijpa.repository;

import by.fallasllepbaby.springrestapijpa.model.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartmentName(String name);

    @Query("FROM Employee WHERE department.name = :name")
    List<Employee> getEmployeesByDeptName(String name);
}
