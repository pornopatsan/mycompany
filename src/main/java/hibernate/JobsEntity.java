package hibernate;

import javax.persistence.*;

@Entity
@Table(name = "jobs", schema = "public", catalog = "pracbackend")
public class JobsEntity {
    private int id;
    private String function;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

        if (id != that.id) return false;
        if (function != null ? !function.equals(that.function) : that.function != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (function != null ? function.hashCode() : 0);
        return result;
    }
}
