package eu.shishigami.orchester.domain.entity;

import eu.shishigami.orchester.util.JsonDateDeserializer;
import eu.shishigami.orchester.util.JsonDateSerializer;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Marcel Herd on 10.03.14.
 */
@Entity
public class PersonEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE }, mappedBy = "person")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonManagedReference
    private List<InstrumentEntity> instrumente = new ArrayList<InstrumentEntity>();

    @NotBlank
    private String vorname;

    @NotBlank
    private String nachname;

    @NotNull
    private Date geburtsdatum;

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    public Date getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(Date geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<InstrumentEntity> getInstrumente() {
        return instrumente;
    }

    public void setInstrumente(List<InstrumentEntity> instrumente) {
        this.instrumente = instrumente;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonEntity that = (PersonEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "PersonEntity{" +
                "id=" + id +
                ", instrumente=" + instrumente +
                ", vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                ", geburtsdatum=" + geburtsdatum +
                '}';
    }

}
