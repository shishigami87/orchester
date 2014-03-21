package eu.shishigami.orchester.util;

import eu.shishigami.orchester.domain.entity.AdresseEntity;
import eu.shishigami.orchester.domain.entity.KlasseEntity;
import eu.shishigami.orchester.domain.entity.StudentEntity;
import eu.shishigami.orchester.domain.service.AdresseService;
import eu.shishigami.orchester.domain.service.KlasseService;
import eu.shishigami.orchester.domain.service.StudentService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
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

    @Autowired
    private KlasseService klasseService;

    @PostConstruct
    public void init() {
        if (!initialized) {
            initialized = true;
            testUltimativesFind();
        }
    }

    private void testUltimativesFind() {
        DateTime dateTime = new DateTime().withDate(1993, 1, 1);
        Date startDate = dateTime.toDate();

        dateTime = dateTime.withDate(1995, 12, 31);
        Date endDate = dateTime.toDate();

        List<String> vornameWhitelist = Arrays.asList(new String[] {
                "Marcel", "Marc", "Martin", "Kevin", "Dennis"
        });

        List<String> nachnameBlacklist = Arrays.asList(new String[] {
                "Müller", "Mayer"
        });

        StudentEntity shouldFind = new StudentEntity();
        shouldFind.setVorname("Marc");
        shouldFind.setNachname("Weinmann");
        shouldFind.setGeburtsdatum(new DateTime().withDate(1994, 1, 1).toDate());
        studentService.save(shouldFind);

        StudentEntity shouldNotFind = new StudentEntity();
        shouldNotFind.setVorname("NotMarc");
        shouldNotFind.setNachname("Egal");
        shouldNotFind.setGeburtsdatum(new DateTime().withDate(1994, 1, 1).toDate());
        studentService.save(shouldNotFind);

        StudentEntity partialMatch = new StudentEntity();
        partialMatch.setVorname("Marc");
        partialMatch.setNachname("Müller");
        partialMatch.setGeburtsdatum(new DateTime().withDate(1994, 1, 1).toDate());
        studentService.save(partialMatch);

        List<StudentEntity> results = studentService.findByGeburtsdatumBetweenAndVornameInAndNachnameNotIn(startDate, endDate, vornameWhitelist, nachnameBlacklist);
        for (StudentEntity studentEntity : results) {
            System.out.println(studentEntity);
        }
    }

    private void testFindByKlasse() {
        System.out.println("Test FindByKlasse");

        KlasseEntity klasseEntity = new KlasseEntity();
        klasseEntity.setName("FIAE");
        klasseEntity.setJahrgang(11);
        klasseEntity.setStudenten(studentService.findAll());

        System.out.println("Saving Klasse...");
        klasseEntity = klasseService.save(klasseEntity);

        StudentEntity studentEntity_ = studentService.findOne(1L);
        studentEntity_.setKlasse(klasseService.findOne(klasseEntity.getId()));
        studentService.save(studentEntity_);

        System.out.println("Selecting students by klasse...");
        List<StudentEntity> results = studentService.findByKlasse(klasseEntity);
        for (StudentEntity studentEntity : results) {
            System.out.println(studentEntity);
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
