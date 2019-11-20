package altarix.test.departments.repository;

import altarix.test.departments.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findAll();

    Department findDepartmentByName(String name);

    List<Department> findAllByParentDepartmentId(Long id);
}
