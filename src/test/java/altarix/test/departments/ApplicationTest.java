package altarix.test.departments;

import altarix.test.departments.model.Department;
import altarix.test.departments.model.Employee;
import altarix.test.departments.model.enums.Position;
import altarix.test.departments.service.DepartmentService;
import altarix.test.departments.service.EmployeeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

@RunWith(SpringRunner.class)
@Sql(scripts = {"classpath:schema.sql", "classpath:test-data.sql"})
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;


    @Test
    public void test() {

            Employee employee = new Employee();
            employee.setLastName("ФАМИЛИЯ");
            employee.setFirstName("ИМЯ");
            employee.setMiddleName("ОТЧЕСТВО");
            employee.setGender("ПОЛ");
            employee.setDateBirth(Date.valueOf(LocalDate.of(1990, 3, 1)));
            employee.setPhone("2(440)081-82-09");
            employee.setEmail("folupellar-7243@yopmail.com");
            employee.setEmploymentDate(Date.valueOf(LocalDate.of(2009, 1, 4)));
            employee.setEmployeePosition(Position.WORKER);
            employee.setSalary(new BigDecimal(100000));
            employee.setLeaderFlag(true);

            Department department = new Department();
            department.setName("ДЕПАРТАМЕНТ");
            department.setDataCreate(Date.valueOf(LocalDate.of(2009, 1, 4)));

            Assert.assertNotNull(departmentService.createDepartment(department));
            Department newDepartment = departmentService.getByName(department.getName());
            Assert.assertEquals("ДЕПАРТАМЕНТ", newDepartment.getName());

            employee.setDepartment(newDepartment);
            Assert.assertNotNull(employeeService.createEmployee(employee));

            Employee employee2 = new Employee();
            employee2.setLastName("ФАМИЛИЯ2");
            employee2.setFirstName("ИМЯ2");
            employee2.setMiddleName("ОТЧЕСТВО2");
            employee2.setGender("ПОЛ");
            employee2.setDateBirth(Date.valueOf(LocalDate.of(1991, 3, 1)));
            employee2.setPhone("2(440)081-82-09");
            employee2.setEmail("folupellar-7243@yopmail.com");
            employee2.setEmploymentDate(Date.valueOf(LocalDate.of(2008, 1, 4)));
//        employee2.setDismissalDate();
            employee2.setEmployeePosition(Position.WORKER);
            employee2.setSalary(new BigDecimal(120000));
            employee2.setLeaderFlag(true);

            employee2.setDepartment(newDepartment);
            Assert.assertNotNull(employeeService.createEmployee(employee2));

            Department department2 = new Department();
            department2.setName("ДЕПАРТАМЕНТ2");
            department2.setDataCreate(Date.valueOf(LocalDate.of(2010, 1, 4)));
            department2.setParentDepartmentId(departmentService.getByName(department.getName()).getId());

            Assert.assertNotNull(departmentService.createDepartment(department2));

            //проверка SQL
            Assert.assertEquals("Департамент 1го ур. вложеность 1",
                    departmentService.getByName("Департамент 1го ур. вложеность 1").getName());
    }
}
