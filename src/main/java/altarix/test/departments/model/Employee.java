package altarix.test.departments.model;

import altarix.test.departments.model.enums.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable = false)
    private Long id;

    @Column(name = "last_name", nullable = false, length = 40)
    private String lastName;

    @Column(name = "first_name", nullable = false, length = 40)
    private String firstName;

    @Column(name = "middle_name", length = 40)
    private String middleName;

    @Column(name = "gender", nullable = false, length = 20)
    private String gender;

    @Column(name = "date_birth", nullable = false)
    private Date dateBirth;

    @Column(name = "phone", nullable = false, length = 40)
    private String phone;

    @Column(name = "email", nullable = false, length = 40)
    private String email;

    @Column(name = "employment_date", nullable = false)
    private Date employmentDate;

    @Column(name = "dismissal_date")
    private Date dismissalDate;

    @Column(name = "employee_position", nullable = false)
    @Enumerated(EnumType.STRING)
    private Position employeePosition;

    @Column(name = "salary", nullable = false)
    private BigDecimal salary;

    @Column(name = "leader_flag", nullable = false)
    private Boolean leaderFlag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="department_id")
    private Department department;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", gender='" + gender + '\'' +
                ", dateBirth=" + dateBirth +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", employmentDate=" + employmentDate +
                ", dismissalDate=" + dismissalDate +
                ", employeePosition=" + employeePosition +
                ", salary=" + salary +
                ", leaderFlag=" + leaderFlag +
                ", department=" + department +
                '}';
    }
}
