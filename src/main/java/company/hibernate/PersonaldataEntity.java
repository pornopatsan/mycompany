package company.hibernate;

import javax.annotation.Generated;
import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "personaldata", schema = "public", catalog = "pracbackend")
public class PersonaldataEntity {
    private Integer id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String phone;
    private String email;
    private String address;
    private String education;
    private String photo;
    private String selfDescription;
    private List<AccountsEntity> accountsById;
    private List<EmployeeEntity> employeesById;

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
    @Column(name = "first_name", nullable = true, length = 16)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = true, length = 16)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "birth_date", nullable = true)
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 16)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 32)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 64)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "education", nullable = true, length = 64)
    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Basic
    @Column(name = "photo", nullable = true, length = 16)
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "self_description", nullable = true, length = 256)
    public String getSelfDescription() {
        return selfDescription;
    }

    public void setSelfDescription(String selfDescription) {
        this.selfDescription = selfDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonaldataEntity that = (PersonaldataEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (birthDate != null ? !birthDate.equals(that.birthDate) : that.birthDate != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (education != null ? !education.equals(that.education) : that.education != null) return false;
        if (photo != null ? !photo.equals(that.photo) : that.photo != null) return false;
        if (selfDescription != null ? !selfDescription.equals(that.selfDescription) : that.selfDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (education != null ? education.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        result = 31 * result + (selfDescription != null ? selfDescription.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "personaldataByPersonalId", fetch = FetchType.EAGER)
    public List<AccountsEntity> getAccountsById() {
        return accountsById;
    }

    public void setAccountsById(List<AccountsEntity> accountsById) {
        this.accountsById = accountsById;
    }

    @OneToMany(mappedBy = "personaldataByPersonalId", fetch = FetchType.EAGER)
    public List<EmployeeEntity> getEmployeesById() {
        return employeesById;
    }

    public void setEmployeesById(List<EmployeeEntity> employeesById) {
        this.employeesById = employeesById;
    }
}
