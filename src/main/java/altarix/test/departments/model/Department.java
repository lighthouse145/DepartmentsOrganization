package altarix.test.departments.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static org.hibernate.sql.InFragment.NULL;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long id;

    @Column(name = "department_name", nullable = false, length = 60, unique = true)
    private String name;

    @Column(name = "data_create", nullable = false)
    private Date dataCreate;

    @Column(name = "parent_department", columnDefinition = NULL)
    private Long parentDepartmentId;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    @Column(columnDefinition = NULL)
    private List<Employee> employees;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dataCreate=" + dataCreate +
                ", parentDepartmentId=" + parentDepartmentId +
                '}';
    }
}
