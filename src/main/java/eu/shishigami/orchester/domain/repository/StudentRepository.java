package eu.shishigami.orchester.domain.repository;

import eu.shishigami.orchester.domain.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Marcel Herd on 21.03.14.
 */
@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    public List<StudentEntity> findByVorname(String vorname);

}
