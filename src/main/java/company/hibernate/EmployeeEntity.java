package company.hibernate;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "employee", schema = "public", catalog = "pracbackend")
public class EmployeeEntity {
    private Integer id;
    private double salary;
    private Date hireDate;
    private PersonaldataEntity personaldataByPersonalId;
    private JobsEntity jobsByJobId;

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

        return Objects.equals(id, that.id);
    }

    public int hashCode(double salary) {
        return id != null ? id.hashCode() : 0;
    }

    @ManyToOne(cascade = CascadeType.ALL)
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
