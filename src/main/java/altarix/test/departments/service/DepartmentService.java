package altarix.test.departments.service;

import altarix.test.departments.model.Department;

import java.math.BigDecimal;
import java.util.List;

public interface DepartmentService {
    void createDepartment(Department department);

    void updateDepartmentName(Department department, String name);

    void deleteDepartment(Department department);

    String getDepartmentInfoByName(String name);

    List<Department> getChildrenDepartments(Department department);

    List<Department> getAllDependentDepartments(Department department);

    void changeDepartmentParent(Department departmentChild, Department departmentParent);

    List<Department> getAllHigherDepartmentsByName(Department department);

    Department getDepartmentByName(String name);

    BigDecimal getDepartmentSalaryByName(String name);
}
