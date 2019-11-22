package altarix.test.departments.service;

import altarix.test.departments.model.Department;

import java.math.BigDecimal;
import java.util.List;

public interface DepartmentService {
    Department createDepartment(Department department);

    Department updateDepartmentName(String newName, String nameDepartment);

    void deleteDepartment(String nameDepartment);

    String getDepartmentInfoByName(String nameDepartment);

    List<Department> getChildrenDepartments(String nameDepartment);

    List<Department> getAllDependentDepartments(String nameDepartment);

    Department changeDepartmentParent(String nameChildDepartment, String nameNewParentDepartment);

    List<Department> getAllHigherDepartments(String nameDepartment);

    Department getByName(String nameDepartment);

    BigDecimal getDepartmentSalaryByName(String nameDepartment);
}
