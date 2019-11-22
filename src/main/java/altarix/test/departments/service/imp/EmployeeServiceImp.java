package altarix.test.departments.service.imp;

import altarix.test.departments.model.Department;
import altarix.test.departments.model.Employee;
import altarix.test.departments.model.enums.Position;
import altarix.test.departments.repository.EmployeeRepository;
import altarix.test.departments.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<Employee> findAllEmployees(Long id) {
        return employeeRepository.findAllByDepartmentId(id);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee dismissEmployee(Employee employee, Date dismissDate) {
        Employee newEmployee = null;
        if (employee.getEmploymentDate().before(dismissDate)) {
            employee.setDismissalDate(dismissDate);
            newEmployee = employeeRepository.save(employee);
        }
        return newEmployee;
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        return employeeRepository.getById(employeeId);
    }

    //    Перевод сотрудника из одного департамента в другой.
    @Override
    public void moveEmployeeToOtherDepartment(Employee employee, Department department) {
        employee.setDepartment(department);
        employeeRepository.save(employee);
    }

    //    Перевод всех сотрудников департамента в другой департамент.
    @Override
    public void moveAllEmployeesToOtherDepartment(List<Employee> employees, Department department) {
        Long departmentId = department.getId();
        List<Employee> allEmployee = employeeRepository.findAllByDepartmentId(departmentId);
        for (Employee employee : allEmployee) {
            employee.setDepartment(department);
        }
        employeeRepository.save(allEmployee);
    }

    //    Получение информации о руководителе данного сотрудника.
    @Override
    public Employee getEmployeeLeader(Employee employee) {
        Employee lead = null;
        Long departmentId = employee.getDepartment().getId();
        List<Employee> allEmployee = employeeRepository.findAllByDepartmentId(departmentId);
        for (Employee currentEmployee : allEmployee) {
            if (currentEmployee.getLeaderFlag()) {
                lead = currentEmployee;
            }
        }
        return lead;
    }

    //    Поиск сотрудников по атрибутам (по каким – решить самостоятельно).
    @Override
    public List<Employee> findEmployeesByGender(String gender) {
        return employeeRepository.findEmployeesByGender(gender);
    }





    //побочный
    public Employee setLeader(Employee employee) {
        Employee dbEmployee = employeeRepository.getById(employee.getId());
        List<Employee> leaderEmployees = employeeRepository.findAll(new Sort("leader_flag = true"));
        if (leaderEmployees.isEmpty()) {
            dbEmployee.setLeaderFlag(true);
            dbEmployee.setEmployeePosition(Position.LEADER);
            employeeRepository.save(dbEmployee);
        }
        return dbEmployee;
    }

    //побочный
    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }

    //побочный
    public void deleteAllEmployees() {
        employeeRepository.deleteAll();
    }

}