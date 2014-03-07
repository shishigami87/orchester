package eu.shishigami.orchester.web.controller;

import eu.shishigami.orchester.domain.entity.AdresseEntity;
import eu.shishigami.orchester.domain.service.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Shishigami on 28.02.14.
 */
@Controller
@RequestMapping("/adresse")
public class AdresseController {

    @Autowired
    private AdresseService adresseService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<AdresseEntity> getAllAdressen() {
        return adresseService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody AdresseEntity saveAdresse(@RequestBody AdresseEntity adresseEntity) {
        System.out.println(adresseEntity.toString());
        return adresseService.save(adresseEntity);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public @ResponseBody AdresseEntity getAdresseById(@PathVariable Long id) {
        return adresseService.findOne(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteAdresse(@PathVariable Long id) {
        AdresseEntity adresseEntity = adresseService.findOne(id);
        adresseService.delete(adresseEntity);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleBadRequest(HttpMessageNotReadableException e) {
        e.printStackTrace();
    }

}
