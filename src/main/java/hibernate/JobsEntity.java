package hibernate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "jobs", schema = "public", catalog = "pracbackend")
public class JobsEntity {
    private Integer id;
    private String function;
    private List<EmployeeEntity> employeesById;
    private List<EmployeejobsHistoryEntity> employeejobsHistoriesById;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "function", nullable = true, length = 20)
    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JobsEntity that = (JobsEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (function != null ? !function.equals(that.function) : that.function != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (function != null ? function.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "jobsByJobId")
    public List<EmployeeEntity> getEmployeesById() {
        return employeesById;
    }

    public void setEmployeesById(List<EmployeeEntity> employeesById) {
        this.employeesById = employeesById;
    }

    @OneToMany(mappedBy = "jobsByJobId")
    public List<EmployeejobsHistoryEntity> getEmployeejobsHistoriesById() {
        return employeejobsHistoriesById;
    }

    public void setEmployeejobsHistoriesById(List<EmployeejobsHistoryEntity> employeejobsHistoriesById) {
        this.employeejobsHistoriesById = employeejobsHistoriesById;
    }
}
