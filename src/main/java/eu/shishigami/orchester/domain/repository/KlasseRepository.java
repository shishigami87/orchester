package eu.shishigami.orchester.domain.repository;

import eu.shishigami.orchester.domain.entity.KlasseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Marcel Herd on 21.03.14.
 */
@Repository
public interface KlasseRepository extends JpaRepository<KlasseEntity, Long> {

}
