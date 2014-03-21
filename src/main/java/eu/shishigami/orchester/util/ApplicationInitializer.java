package eu.shishigami.orchester.util;

import eu.shishigami.orchester.domain.entity.AdresseEntity;
import eu.shishigami.orchester.domain.service.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Marcel Herd on 21.03.14.
 */
@Component
public class ApplicationInitializer {

    private static boolean initialized = false;

    @Autowired
    private AdresseService adresseService;

    @PostConstruct
    public void init() {
        if (!initialized) {
            initialized = true;
            printAllAdressen();
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
