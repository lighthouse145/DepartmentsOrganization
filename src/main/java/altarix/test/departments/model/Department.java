package altarix.test.departments.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "department_id", nullable = false)
    private Long id;

    @Column(name = "department_name", nullable = false, length = 40)
    private String name;

    @Column(name = "data_create", nullable = false)
    private Date dataCreate;

    @Column(name = "parent_department")
    private Long parentDepartmentId;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees = new LinkedList<>();

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDataCreate(Date dataCreate) {
        this.dataCreate = dataCreate;
    }

    public void setParentDepartmentId(Long parentDepartmentId) {
        this.parentDepartmentId = parentDepartmentId;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDataCreate() {
        return dataCreate;
    }

    public Long getParentDepartmentId() {
        return parentDepartmentId;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dataCreate=" + dataCreate +
                ", parentDepartment=" + parentDepartmentId +
                '}';
    }
}
