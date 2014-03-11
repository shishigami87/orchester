package eu.shishigami.orchester.domain.entity;

import eu.shishigami.orchester.util.JsonDateDeserializer;
import eu.shishigami.orchester.util.JsonDateSerializer;
import lombok.*;
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
@Data
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

}
