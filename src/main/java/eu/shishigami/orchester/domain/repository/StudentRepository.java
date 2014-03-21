package eu.shishigami.orchester.domain.repository;

import eu.shishigami.orchester.domain.entity.KlasseEntity;
import eu.shishigami.orchester.domain.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by Marcel Herd on 21.03.14.
 */
@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    public List<StudentEntity> findByVorname(String vorname);

    public List<StudentEntity> findByVornameAndNachname(String vorname, String nachname);

    public List<StudentEntity> findByKlasse(KlasseEntity klasseEntity);

    public List<StudentEntity> findByGeburtsdatumBetweenAndVornameInAndNachnameNotIn(Date startDate, Date endDate, Collection<String> vornameWhitelist, Collection<String> nachnameBlacklist);

}
