package altarix.test.departments.service.imp;

import altarix.test.departments.model.Department;
import altarix.test.departments.model.Employee;
import altarix.test.departments.repository.DepartmentRepository;
import altarix.test.departments.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImp(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department createDepartment(Department department) {
        List<Department> foundNullParentDepartmentId = departmentRepository.findAllByParentDepartmentId(null);
        if (department.getParentDepartmentId() == null && !foundNullParentDepartmentId.isEmpty()) {
            return null;
        } else {
            return departmentRepository.save(department);
        }
    }

    @Override
    public Department updateDepartmentName(String newName, String nameDepartment) {
        Department foundDepartment = departmentRepository.getByName(newName);
        Department currentDepartment = departmentRepository.getByName(nameDepartment);
        if (foundDepartment == null && currentDepartment != null) {
            currentDepartment.setName(newName);
            return departmentRepository.save(currentDepartment);
        }
        return null;
    }

    //todo
    @Override
    public void deleteDepartment(String nameDepartment) {
        Department department = departmentRepository.getByName(nameDepartment);
        List<Department> allDependentDepartments = getAllDependentDepartments(department.getName());
        boolean flagEmployee = false;
        for (Department d : allDependentDepartments) {
            if (d.getEmployees().isEmpty()) {
                continue;
            }
            flagEmployee = true;
        }
        if (!flagEmployee) {
            departmentRepository.delete(allDependentDepartments);
        }
    }

    //todo DepartmentInfo
    @Override
    public String getDepartmentInfoByName(String nameDepartment) {
        Department foundDepartment = departmentRepository.getByName(nameDepartment);
        if (foundDepartment == null) {
            return "Department not found";
        } else {
            Date dataCreate = foundDepartment.getDataCreate();
            List<Employee> employees = foundDepartment.getEmployees();
            Employee leader = null;
            int number = 0;
            if (!employees.isEmpty()) {
                for (Employee e : employees) {
                    if (e.getLeaderFlag()) leader = e;
                }
                number = employees.size();
            }
            return "DepartmentInfo{" +
                    " name=" + nameDepartment +
                    ", dataCreate=" + dataCreate +
                    ", leader=" + leader +
                    ", numberOfEmployees=" + number +
                    '}';
        }
    }

    @Override
    public List<Department> getChildrenDepartments(String name) {
        Department department = departmentRepository.getByName(name);
        if (department != null) {
            return departmentRepository.findAllByParentDepartmentId(department.getId());
        }
        return new LinkedList<>();
    }

    //todo найти лучше вариант
    @Override
    public List<Department> getAllDependentDepartments(String name) {
        Department department = departmentRepository.getByName(name);
        if (department != null) {
            LinkedList<Department> departments = new LinkedList<>();
            departments.add(department);
            return findChildren(departments);
        }
        return new LinkedList<>();
    }

    private List<Department> findChildren(List<Department> departments) {
        List<Department> childrens = new LinkedList<>();
        if (departments != null) {
            for (Department departament : departments) {
                List<Department> childDepartments = getChildrenDepartments(departament.getName());
                if (childDepartments != null) {
                    childrens.addAll(childDepartments);
                }
            }
            if (!childrens.isEmpty()) {
                childrens.addAll(findChildren(childrens));
            }
        }
        return childrens;
    }

    @Override
    public Department changeDepartmentParent(String nameChildDepartment, String nameNewParentDepartment) {
        Department childDepartment = departmentRepository.getByName(nameChildDepartment);
        Department newParentDepartment = departmentRepository.getByName(nameNewParentDepartment);
        Department newDepartment = null;
        if (childDepartment != null && newParentDepartment != null) {
            childDepartment.setParentDepartmentId(newParentDepartment.getId());
            newDepartment = departmentRepository.save(childDepartment);
        }
        return newDepartment;
    }

    @Override
    public List<Department> getAllHigherDepartments(String name) {
        Department department = departmentRepository.getByName(name);
        List<Department> parents = new LinkedList<>();
        if (department != null) {
            Long currentParentId = department.getParentDepartmentId();
            while (currentParentId != null) {
                Department currentParent = departmentRepository.findOne(currentParentId);
                parents.add(currentParent);
                currentParentId = currentParent.getId();
            }
        }
        return parents;
    }

    //todo сделать лучше
    //суммарная зарплата по департаменту
    @Override
    public BigDecimal getDepartmentSalaryByName(String nameDepartment) {
        Department department = departmentRepository.getByName(nameDepartment);
        List<Employee> employees = department.getEmployees();
        MathContext mc = new MathContext(5);
        BigDecimal number = new BigDecimal("0.0");
        for (Employee e : employees) {
            number.add(e.getSalary(), mc);
        }
        return number;
    }

    @Override
    public Department getByName(String name) {
        return departmentRepository.getByName(name);
    }


    public List<Department> getAll() {
        return departmentRepository.findAll();
    }


    public Department addEmployee(Employee employee, Department department) {
        if (department != null) {
            List<Employee> employees = department.getEmployees();
            employees.add(employee);
            department.setEmployees(employees);
        }
        return departmentRepository.save(department);
    }


    public Department addEmployees(List<Employee> newEmployees, Department department) {
        if (department != null) {
            List<Employee> employees = department.getEmployees();
            employees.addAll(newEmployees);
            department.setEmployees(employees);
        }
        return departmentRepository.save(department);
    }


    public Department getById(Long id) {
        return departmentRepository.getById(id);
    }
}
