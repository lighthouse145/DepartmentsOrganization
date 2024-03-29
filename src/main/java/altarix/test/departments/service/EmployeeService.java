package altarix.test.departments.service;

import altarix.test.departments.model.Department;
import altarix.test.departments.model.Employee;

import java.sql.Date;
import java.util.List;

public interface EmployeeService {
    List<Employee> findAllEmployees(Long departmentId);

    Employee createEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    Employee dismissEmployee(Employee employee, Date date);

    Employee getEmployeeById(Long employeeId);

    void moveEmployeeToOtherDepartment(Employee employee, Department department);

    void moveAllEmployeesToOtherDepartment(List<Employee> employees, Department department);

    Employee getEmployeeLeader(Employee employee);

    List<Employee> findEmployeesByGender(String gender);
}
