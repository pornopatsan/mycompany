package company.hibernate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "location", schema = "public", catalog = "pracbackend")
public class LocationEntity {
    private Integer id;
    private String country;
    private String region;
    private List<OfficeEntity> officesById;

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
    @Column(name = "country", nullable = true, length = 32)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "region", nullable = true, length = 32)
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocationEntity that = (LocationEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (region != null ? !region.equals(that.region) : that.region != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "locationByLocationId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public List<OfficeEntity> getOfficesById() {
        return officesById;
    }

    public void setOfficesById(List<OfficeEntity> officesById) {
        this.officesById = officesById;
    }
}
