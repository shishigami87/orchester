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
 * Created by MarcelNoir on 10.03.14.
 */
@Service
public class InstrumentService {
    
    @Autowired
    private InstrumentRepository instrumentRepository;

    private void delete(final Long id) {
        instrumentRepository.delete(id);
    }

    private void delete(final InstrumentEntity instrumentEntity) {
        instrumentRepository.delete(instrumentEntity);
    }

    private InstrumentEntity save(final InstrumentEntity instrumentEntity) {
        return instrumentRepository.save(instrumentEntity);
    }

    private InstrumentEntity findOne(final Long id) {
        return instrumentRepository.findOne(id);
    }

    private List<InstrumentEntity> findAll() {
        return instrumentRepository.findAll();
    }

    private List<InstrumentEntity> findAll(final Sort sort) {
        return instrumentRepository.findAll();
    }

    private Page<InstrumentEntity> findAll(final Pageable pageable) {
        return instrumentRepository.findAll(pageable);
    }
    
}
