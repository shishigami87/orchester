package eu.shishigami.orchester.domain.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcel Herd on 21.03.14.
 */
@Entity
public class KlasseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int jahrgang;

    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE }, mappedBy = "klasse")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<StudentEntity> studenten = new ArrayList<StudentEntity>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJahrgang() {
        return jahrgang;
    }

    public void setJahrgang(int jahrgang) {
        this.jahrgang = jahrgang;
    }

    public List<StudentEntity> getStudenten() {
        return studenten;
    }

    public void setStudenten(List<StudentEntity> studenten) {
        this.studenten = studenten;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KlasseEntity that = (KlasseEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("KlasseEntity{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", jahrgang=").append(jahrgang);
        sb.append('}');
        return sb.toString();
    }

}
