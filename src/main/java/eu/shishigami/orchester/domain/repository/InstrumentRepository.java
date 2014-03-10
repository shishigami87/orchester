package eu.shishigami.orchester.domain.repository;

import eu.shishigami.orchester.domain.entity.InstrumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by MarcelNoir on 10.03.14.
 */
@Repository
public interface InstrumentRepository extends JpaRepository<InstrumentEntity, Long> {

}
