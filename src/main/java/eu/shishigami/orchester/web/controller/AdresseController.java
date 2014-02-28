package eu.shishigami.orchester.web.controller;

import eu.shishigami.orchester.domain.entity.AdresseEntity;
import eu.shishigami.orchester.domain.service.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Shishigami on 28.02.14.
 */
@Controller
@RequestMapping("/adresse")
public class AdresseController {

    @Autowired
    private AdresseService adresseService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public @ResponseBody AdresseEntity getAdresseById(@PathVariable Long id) {
        return adresseService.findOne(id);
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public @ResponseBody List<AdresseEntity> getAllAdressen() {
        return adresseService.findAll();
    }

}
