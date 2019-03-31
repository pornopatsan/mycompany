package hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "employeejobs_history", schema = "public", catalog = "pracbackend")
public class EmployeejobsHistoryEntity {
    private Integer id;
    private Date appointment;
    private Date removal;
    private BigDecimal salary;
    private EmployeeEntity employeeByEmployeeId;
    private JobsEntity jobsByJobId;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "appointment", nullable = true)
    public Date getAppointment() {
        return appointment;
    }

    public void setAppointment(Date appointment) {
        this.appointment = appointment;
    }

    @Basic
    @Column(name = "removal", nullable = true)
    public Date getRemoval() {
        return removal;
    }

    public void setRemoval(Date removal) {
        this.removal = removal;
    }

    @Basic
    @Column(name = "salary", nullable = true, precision = 2)
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeejobsHistoryEntity that = (EmployeejobsHistoryEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (appointment != null ? !appointment.equals(that.appointment) : that.appointment != null) return false;
        if (removal != null ? !removal.equals(that.removal) : that.removal != null) return false;
        if (salary != null ? !salary.equals(that.salary) : that.salary != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (appointment != null ? appointment.hashCode() : 0);
        result = 31 * result + (removal != null ? removal.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    public EmployeeEntity getEmployeeByEmployeeId() {
        return employeeByEmployeeId;
    }

    public void setEmployeeByEmployeeId(EmployeeEntity employeeByEmployeeId) {
        this.employeeByEmployeeId = employeeByEmployeeId;
    }

    @ManyToOne
    @JoinColumn(name = "job_id", referencedColumnName = "id")
    public JobsEntity getJobsByJobId() {
        return jobsByJobId;
    }

    public void setJobsByJobId(JobsEntity jobsByJobId) {
        this.jobsByJobId = jobsByJobId;
    }
}
