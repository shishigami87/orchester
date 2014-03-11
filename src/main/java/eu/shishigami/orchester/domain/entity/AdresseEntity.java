package eu.shishigami.orchester.domain.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Marcel Herd on 28.02.14.
 */
@Entity
@Data
public class AdresseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private int plz;

    @NotNull
    private int hausnummer;

    @NotBlank
    private String strasse;

    @NotBlank
    private String ort;

}
