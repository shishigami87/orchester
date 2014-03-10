package eu.shishigami.orchester.domain.service;

import eu.shishigami.orchester.domain.entity.AdresseEntity;
import eu.shishigami.orchester.domain.repository.AdresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Marcel Herd on 28.02.14.
 */
@Service
public class AdresseService {

    @Autowired
    private AdresseRepository adresseRepository;

    public void delete(final AdresseEntity adresseEntity) {
        adresseRepository.delete(adresseEntity);
    }

    public AdresseEntity save(final AdresseEntity adresseEntity) {
        return adresseRepository.save(adresseEntity);
    }

    public AdresseEntity findOne(final Long id) {
        return adresseRepository.findOne(id);
    }

    public List<AdresseEntity> findAll() {
        return adresseRepository.findAll();
    }

}
