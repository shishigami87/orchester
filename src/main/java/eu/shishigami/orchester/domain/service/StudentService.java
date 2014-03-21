package eu.shishigami.orchester.domain.service;

import eu.shishigami.orchester.domain.entity.StudentEntity;
import eu.shishigami.orchester.domain.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Shishigami on 21.03.14.
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

    public Iterable<StudentEntity> findAll() {
        return studentRepository.findAll();
    }

}
