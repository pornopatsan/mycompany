package hibernate;

import javax.persistence.*;

@Entity
@Table(name = "accounts", schema = "public", catalog = "pracbackend")
public class AccountsEntity {
    private String login;
    private String passwordd;
    private Integer personalId;
    private PersonaldataEntity personaldataByPersonalId;

    @Id
    @Column(name = "login", nullable = false, length = 16)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "passwordd", nullable = true, length = 32)
    public String getPasswordd() {
        return passwordd;
    }

    public void setPasswordd(String passwordd) {
        this.passwordd = passwordd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountsEntity that = (AccountsEntity) o;

        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (passwordd != null ? !passwordd.equals(that.passwordd) : that.passwordd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (passwordd != null ? passwordd.hashCode() : 0);
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

    @ManyToOne
    @JoinColumn(name = "personal_id", referencedColumnName = "id")
    public PersonaldataEntity getPersonaldataByPersonalId() {
        return personaldataByPersonalId;
    }

    public void setPersonaldataByPersonalId(PersonaldataEntity personaldataByPersonalId) {
        this.personaldataByPersonalId = personaldataByPersonalId;
    }
}
