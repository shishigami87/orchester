package eu.shishigami.orchester.domain.service;

import eu.shishigami.orchester.domain.entity.InstrumentEntity;
import eu.shishigami.orchester.domain.repository.InstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Marcel Herd on 10.03.14.
 */
@Service
public class InstrumentService {
    
    @Autowired
    private InstrumentRepository instrumentRepository;

    public void delete(final Long id) {
        instrumentRepository.delete(id);
    }

    public void delete(final InstrumentEntity instrumentEntity) {
        instrumentRepository.delete(instrumentEntity);
    }

    public InstrumentEntity save(final InstrumentEntity instrumentEntity) {
        return instrumentRepository.save(instrumentEntity);
    }

    public InstrumentEntity findOne(final Long id) {
        return instrumentRepository.findOne(id);
    }

    public List<InstrumentEntity> findAll() {
        return instrumentRepository.findAll();
    }

    public List<InstrumentEntity> findAll(final Sort sort) {
        return instrumentRepository.findAll();
    }

    public Page<InstrumentEntity> findAll(final Pageable pageable) {
        return instrumentRepository.findAll(pageable);
    }
    
}
