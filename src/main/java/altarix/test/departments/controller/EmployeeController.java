package altarix.test.departments.controller;

import altarix.test.departments.model.Employee;
import altarix.test.departments.service.EmployeeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static altarix.test.departments.controller.EmployeeController.URL;

@Api(value = URL, description = "Предоставляет API для работы с сотрудниками департамента")
@RestController
@RequestMapping(value = URL)
public class EmployeeController {
    public static final String URL = "/employees";

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping("/add")
    public Employee add(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PatchMapping("/update")
    public Employee update(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

}
