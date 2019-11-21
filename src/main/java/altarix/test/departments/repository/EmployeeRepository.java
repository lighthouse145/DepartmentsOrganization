package altarix.test.departments.repository;

import altarix.test.departments.model.Employee;
import altarix.test.departments.model.enums.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee getById(Long id);

    List<Employee> findAll();

    List<Employee> findAllByDepartmentId(Long id);

    Employee findEmployeesByEmployeePosition(Position position);

    List<Employee> findEmployeesByGender(String gender);
}
