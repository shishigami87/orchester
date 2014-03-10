package eu.shishigami.orchester.domain.entity;

import lombok.Data;

import javax.persistence.*;
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

    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE })
    private List<InstrumentEntity> instrumente = new ArrayList<InstrumentEntity>();

    private String vorname;

    private String nachname;

    private Date geburtsdatum;

    private int alter;

}
