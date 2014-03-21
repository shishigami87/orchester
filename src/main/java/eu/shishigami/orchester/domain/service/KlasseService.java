package eu.shishigami.orchester.domain.service;

import eu.shishigami.orchester.domain.entity.KlasseEntity;
import eu.shishigami.orchester.domain.repository.KlasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Shishigami on 21.03.14.
 */
@Service
public class KlasseService {

    @Autowired
    private KlasseRepository klasseRepository;

    public void delete(final Long id) {
        klasseRepository.delete(id);
    }

    public void delete(final KlasseEntity klasseEntity) {
        klasseRepository.delete(klasseEntity);
    }

    public KlasseEntity save(final KlasseEntity klasseEntity) {
        return klasseRepository.save(klasseEntity);
    }

    public KlasseEntity findOne(final Long id) {
        return klasseRepository.findOne(id);
    }

    public Iterable<KlasseEntity> findAll() {
        return klasseRepository.findAll();
    }

}
