package hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "employee", schema = "public", catalog = "pracbackend")
public class EmployeeEntity {
    private int id;
    private BigDecimal salary;
    private Date hireDate;
    private Integer personalId;
    private Integer jobId;
    private PersonaldataEntity personaldataByPersonalId;
    private JobsEntity jobsByJobId;
    private Collection<EmployeeDepartmentEntity> employeeDepartmentsById;
    private Collection<EmployeejobsHistoryEntity> employeejobsHistoriesById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "salary", nullable = true, precision = 2)
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "hire_date", nullable = true)
    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeEntity that = (EmployeeEntity) o;

        if (id != that.id) return false;
        if (salary != null ? !salary.equals(that.salary) : that.salary != null) return false;
        if (hireDate != null ? !hireDate.equals(that.hireDate) : that.hireDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (hireDate != null ? hireDate.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "personal_id", nullable = true)
    public Integer getPersonalId() {
        return personalId;
    }

    public void setPersonalId(Integer personalId) {
        this.personalId = personalId;
    }

    @Basic
    @Column(name = "job_id", nullable = true)
    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    @ManyToOne
    @JoinColumn(name = "personal_id", referencedColumnName = "id")
    public PersonaldataEntity getPersonaldataByPersonalId() {
        return personaldataByPersonalId;
    }

    public void setPersonaldataByPersonalId(PersonaldataEntity personaldataByPersonalId) {
        this.personaldataByPersonalId = personaldataByPersonalId;
    }

    @ManyToOne
    @JoinColumn(name = "job_id", referencedColumnName = "id")
    public JobsEntity getJobsByJobId() {
        return jobsByJobId;
    }

    public void setJobsByJobId(JobsEntity jobsByJobId) {
        this.jobsByJobId = jobsByJobId;
    }

    @OneToMany(mappedBy = "employeeByEmployeeId")
    public Collection<EmployeeDepartmentEntity> getEmployeeDepartmentsById() {
        return employeeDepartmentsById;
    }

    public void setEmployeeDepartmentsById(Collection<EmployeeDepartmentEntity> employeeDepartmentsById) {
        this.employeeDepartmentsById = employeeDepartmentsById;
    }

    @OneToMany(mappedBy = "employeeByEmployeeId")
    public Collection<EmployeejobsHistoryEntity> getEmployeejobsHistoriesById() {
        return employeejobsHistoriesById;
    }

    public void setEmployeejobsHistoriesById(Collection<EmployeejobsHistoryEntity> employeejobsHistoriesById) {
        this.employeejobsHistoriesById = employeejobsHistoriesById;
    }
}
