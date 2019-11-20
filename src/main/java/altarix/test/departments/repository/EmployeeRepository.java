package altarix.test.departments.repository;

import altarix.test.departments.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAll();

    List<Employee> findAllByDepartmentId(Long departmentId);

    Employee getById(Long id);

    //    Поиск сотрудников по атрибутам (по каким – решить самостоятельно).
    List<Employee> findEmployeesByGender(String gender);

    @Query("select e from employee e where e.leader_flag = true")
    List<Employee> findAllLaders();
}
