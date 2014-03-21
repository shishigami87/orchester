package eu.shishigami.orchester.domain.repository;

import eu.shishigami.orchester.domain.entity.KlasseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Shishigami on 21.03.14.
 */
@Repository
public interface KlasseRepository extends CrudRepository<KlasseEntity, Long> {

}
