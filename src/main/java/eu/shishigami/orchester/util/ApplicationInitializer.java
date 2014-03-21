package eu.shishigami.orchester.util;

import eu.shishigami.orchester.domain.entity.AdresseEntity;
import eu.shishigami.orchester.domain.entity.StudentEntity;
import eu.shishigami.orchester.domain.service.AdresseService;
import eu.shishigami.orchester.domain.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

/**
 * Created by Marcel Herd on 21.03.14.
 */
@Component
public class ApplicationInitializer {

    private static boolean initialized = false;

    @Autowired
    private AdresseService adresseService;

    @Autowired
    private StudentService studentService;

    @PostConstruct
    public void init() {
        if (!initialized) {
            initialized = true;
            testFindByVorNachname();
        }
    }

    private void testFindByVorNachname() {
        System.out.println("Test FindByVorNachname");

        List<StudentEntity> results = studentService.findByVornameAndNachname("Marcel", "Herd");
        for (StudentEntity studentEntity : results) {
            System.out.println(studentEntity);
        }
    }

    private void testFindByVorname() {
        System.out.println("Test FindByVorname...");

        List<StudentEntity> results = studentService.findByVorname("Marcel");
        for (StudentEntity studentEntity : results) {
            System.out.println(studentEntity);
        }

        results = studentService.findByVorname("Gibts net");
        for (StudentEntity studentEntity : results) {
            System.out.println(studentEntity);
        }
    }

    private void testStudentCrud() {
        System.out.println("Test Student CRUD...");

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setVorname("Marcel");
        studentEntity.setNachname("Herd");
        studentEntity.setGeburtsdatum(new Date());

        System.out.println("Creating new entity...");
        studentService.save(studentEntity);

        System.out.println("Selecting one entity...");
        StudentEntity newStudentEntity = studentService.findOne(1L);
        System.out.println(newStudentEntity);

        System.out.println("Selecting all entities...");
        Iterable<StudentEntity> studenten = studentService.findAll();
        for (StudentEntity studentEntity_ : studenten) {
            System.out.println(studentEntity_);
        }
    }

    private void printAllAdressen() {
        System.out.println("Print all Adressen...");
        List<AdresseEntity> adressen = adresseService.findAll();

        for (AdresseEntity adresseEntity : adressen) {
            System.out.println(adresseEntity.toString());
        }
    }

}
