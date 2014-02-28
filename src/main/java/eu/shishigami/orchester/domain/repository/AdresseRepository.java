package eu.shishigami.orchester.domain.repository;

import eu.shishigami.orchester.domain.entity.AdresseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Shishigami on 28.02.14.
 */
@Repository
public interface AdresseRepository extends JpaRepository<AdresseEntity, Long> {

}
