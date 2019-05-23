package company.hibernate;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "employee", schema = "public", catalog = "pracbackend")
public class EmployeeEntity {
    private Integer id;
    private double salary;
    private Date hireDate;
    private PersonaldataEntity personaldataByPersonalId;
    private JobsEntity jobsByJobId;
    private List<EmployeejobsHistoryEntity> employeejobsHistoriesById;

    private Integer tmpPersonalId;
    private Integer tmpJobId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "salary", nullable = true, precision = 2)
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
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

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (salary - that.salary > 0.0001) return false;
        if (hireDate != null ? !hireDate.equals(that.hireDate) : that.hireDate != null) return false;

        return true;
    }

    public int hashCode(double salary) {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (hireDate != null ? hireDate.hashCode() : 0);
        return result;
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

    @OneToMany(mappedBy = "employeeByEmployeeId", fetch = FetchType.EAGER)
    public List<EmployeejobsHistoryEntity> getEmployeejobsHistoriesById() {
        return employeejobsHistoriesById;
    }

    public void setEmployeejobsHistoriesById(List<EmployeejobsHistoryEntity> employeejobsHistoriesById) {
        this.employeejobsHistoriesById = employeejobsHistoriesById;
    }

    @Basic
    public Integer getTmpPersonalId() {
        return tmpPersonalId;
    }
    public void setTmpPersonalId(Integer id) {
        this.tmpPersonalId = id;
    }

    @Basic
    public Integer getTmpJobId() {
        return tmpJobId;
    }
    public void setTmpJobId(Integer id) {
        this.tmpJobId = id;
    }

}
