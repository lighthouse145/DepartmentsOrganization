package altarix.test.departments.controller;

import altarix.test.departments.model.Department;
import altarix.test.departments.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import static altarix.test.departments.controller.DepartmentController.URL;

@Api(value = URL, description = "Предоставляет API для работы со структурой департамента")
@RestController
@RequestMapping(URL)
public class DepartmentController {
    static final String URL = "/departments";

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping(path = "/add",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Создание департамента", notes = "При создании департамента нужно указать информацию о " +
            "департаменте, в который он будет входить. Для самого верхнего департамента такой информации указывать не нужно.")
    @ResponseBody
    public Department add(@RequestBody @Validated Department department) {
        return departmentService.createDepartment(department);
    }


    @PatchMapping(path = "/update",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Изменение наименования департамента",
            notes = "В системе не может быть двух департаментов с одинаковыми наименованиями.")
    @ResponseBody
    public ResponseEntity update(@RequestParam(name = "new name") String newName,
                                 @RequestParam(name = "current name") String nameDepartment) {
        Department response = departmentService.updateDepartmentName(newName, nameDepartment);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //todo каскадное удаление
    @DeleteMapping(path = "/delete",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Удаление департамента", notes = "Удаление возможно, только если в нем нет ни одного сотрудника.")
    public void delete(@RequestBody @RequestParam(name = "name") String name) {
        departmentService.deleteDepartment(name);
    }

    @GetMapping(path = "/departmentInfo",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Просмотр сведений о департаменте", notes = "Должна быть выдана информация о наименовании " +
            "департамента, дате создания, руководителе департамента и количестве сотрудников департамента.")
    @ResponseBody
    public String getDepartmentInfo(@RequestBody @RequestParam(name = "name") String name) {
        return departmentService.getDepartmentInfoByName(name);
    }

    @GetMapping(path = "/childrenDepartments",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Предоставление информации о департаментах на уровень ниже", notes = "Предоставление" +
            " информации о департаментах, находящихся в непосредственном подчинении данного департамента (на уровень ниже)")
    @ResponseBody
    public List<Department> getChildrenDepartments(@RequestBody @RequestParam(name = "name") String name) {
        return departmentService.getChildrenDepartments(name);
    }

    @GetMapping(path = "/allDependentDepartments",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Предоставление информации о всех подчиненных департаментах",
            notes = " Все подчиненные департаменты. Для головного департамента - это все остальные департаменты")
    @ResponseBody
    public List<Department> getAllDependentDepartments(@RequestBody @RequestParam(name = "name") String name) {
        return departmentService.getAllDependentDepartments(name);
    }

    @PostMapping(path = "/changeDepartmentParent",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Перенос департамента в другой департамент",
            notes = "Задание другого департамента, куда будет входить данный департамент.")
    @ResponseBody
    public Department changeDepartmentParent(@RequestBody @RequestParam(name = "name child department") String nameChildDepartment,
                                             @RequestParam(name = "name parent department") String nameNewParentDepartment) {
        return departmentService.changeDepartmentParent(nameChildDepartment, nameNewParentDepartment);
    }

    @GetMapping(path = "/allHigherDepartments",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Получение информации о всех вышестоящих департаментах")
    @ResponseBody
    public List<Department> getAllHigherDepartments(@RequestBody @RequestParam(name = "name department") String name) {
        return departmentService.getAllHigherDepartments(name);
    }

    @GetMapping(path = "/department/{name}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Поиск департамента по наименованию")
    @ResponseBody
    public Department getDepartmentByName(@RequestBody @RequestParam(name = "name department") @PathVariable String name) {
        return departmentService.getByName(name);
    }

    @GetMapping(path = "/departmentSalary",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Получение информации о фонде заработной платы департамента ",
            notes = "Сумма зарплат всех сотрудников департамента")
    @ResponseBody
    public BigDecimal getDepartmentSalaryByName(@RequestBody @RequestParam(name = "name department") String nameDepartment) {
        return departmentService.getDepartmentSalaryByName(nameDepartment);
    }
}
