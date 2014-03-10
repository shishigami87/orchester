package eu.shishigami.orchester.domain.service;

import eu.shishigami.orchester.domain.entity.PersonEntity;
import eu.shishigami.orchester.domain.repository.PersonRepository;
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
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    private void delete(final Long id) {
        personRepository.delete(id);
    }

    private void delete(final PersonEntity personEntity) {
        personRepository.delete(personEntity);
    }

    private PersonEntity save(final PersonEntity personEntity) {
        return personRepository.save(personEntity);
    }

    private PersonEntity findOne(final Long id) {
        return personRepository.findOne(id);
    }

    private List<PersonEntity> findAll() {
        return personRepository.findAll();
    }

    private List<PersonEntity> findAll(final Sort sort) {
        return personRepository.findAll();
    }

    private Page<PersonEntity> findAll(final Pageable pageable) {
        return personRepository.findAll(pageable);
    }

}
