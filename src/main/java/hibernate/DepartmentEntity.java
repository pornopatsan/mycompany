package hibernate;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "department", schema = "public", catalog = "pracbackend")
public class DepartmentEntity {
    private Integer id;
    private String name;
    private String description;
    private DepartmentEntity departmentByHeadId;
    private OfficeEntity officeByOfficeId;
    private Collection<DepartmentEntity> departmentsById;
    private Collection<EmployeeDepartmentEntity> employeeDepartmentsById;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 32)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 256)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepartmentEntity that = (DepartmentEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "head_id", referencedColumnName = "id")
    public DepartmentEntity getDepartmentByHeadId() {
        return departmentByHeadId;
    }

    public void setDepartmentByHeadId(DepartmentEntity departmentByHeadId) {
        this.departmentByHeadId = departmentByHeadId;
    }

    @ManyToOne
    @JoinColumn(name = "office_id", referencedColumnName = "id")
    public OfficeEntity getOfficeByOfficeId() {
        return officeByOfficeId;
    }

    public void setOfficeByOfficeId(OfficeEntity officeByOfficeId) {
        this.officeByOfficeId = officeByOfficeId;
    }

    @OneToMany(mappedBy = "departmentByHeadId")
    public Collection<DepartmentEntity> getDepartmentsById() {
        return departmentsById;
    }

    public void setDepartmentsById(Collection<DepartmentEntity> departmentsById) {
        this.departmentsById = departmentsById;
    }

    @OneToMany(mappedBy = "departmentByDepartmentId")
    public Collection<EmployeeDepartmentEntity> getEmployeeDepartmentsById() {
        return employeeDepartmentsById;
    }

    public void setEmployeeDepartmentsById(Collection<EmployeeDepartmentEntity> employeeDepartmentsById) {
        this.employeeDepartmentsById = employeeDepartmentsById;
    }
}
