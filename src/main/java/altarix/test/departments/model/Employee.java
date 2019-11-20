package altarix.test.departments.model;

import altarix.test.departments.model.enums.Position;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Temporal(TemporalType.DATE)
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

    @Column(name = "department_id")
    private Long departmentId;

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
                ", departmentId=" + departmentId +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    public void setDismissalDate(Date dismissalDate) {
        this.dismissalDate = dismissalDate;
    }

    public void setEmployeePosition(Position employeePosition) {
        this.employeePosition = employeePosition;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setLeaderFlag(Boolean leaderFlag) {
        this.leaderFlag = leaderFlag;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getGender() {
        return gender;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public Date getDismissalDate() {
        return dismissalDate;
    }

    public Position getEmployeePosition() {
        return employeePosition;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public Boolean getLeaderFlag() {
        return leaderFlag;
    }

    public Long getDepartmentId() {
        return departmentId;
    }
}
