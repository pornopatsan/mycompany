package company.hibernate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "jobs", schema = "public", catalog = "pracbackend")
public class JobsEntity {
    private Integer id;
    private String function;

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
}
