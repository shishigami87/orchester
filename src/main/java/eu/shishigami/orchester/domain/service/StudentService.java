package eu.shishigami.orchester.domain.service;

import eu.shishigami.orchester.domain.entity.KlasseEntity;
import eu.shishigami.orchester.domain.entity.StudentEntity;
import eu.shishigami.orchester.domain.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by Marcel Herd on 21.03.14.
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void delete(final Long id) {
        studentRepository.delete(id);
    }

    public void delete(final StudentEntity studentEntity) {
        studentRepository.delete(studentEntity);
    }

    public StudentEntity save(final StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    public StudentEntity findOne(final Long id) {
        return studentRepository.findOne(id);
    }

    public List<StudentEntity> findByVorname(final String vorname) {
        return studentRepository.findByVorname(vorname);
    }

    public List<StudentEntity> findByVornameAndNachname(final String vorname, final String nachname) {
        return studentRepository.findByVornameAndNachname(vorname, nachname);
    }

    public List<StudentEntity> findByGeburtsdatumBetweenAndVornameInAndNachnameNotIn(Date startDate, Date endDate, Collection<String> vornameWhitelist, Collection<String> nachnameBlacklist) {
        return studentRepository.findByGeburtsdatumBetweenAndVornameInAndNachnameNotIn(startDate, endDate, vornameWhitelist, nachnameBlacklist);
    }

    public List<StudentEntity> findByKlasse(final KlasseEntity klasseEntity) {
        return studentRepository.findByKlasse(klasseEntity);
    }

    public List<StudentEntity> findAll() {
        return studentRepository.findAll();
    }

}
