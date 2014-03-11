package eu.shishigami.orchester.web.controller;

import eu.shishigami.orchester.domain.entity.PersonEntity;
import eu.shishigami.orchester.domain.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Marcel Herd on 11.03.14.
 */
@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<PersonEntity> getAllPersonen() {
        return personService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody PersonEntity savePerson(@RequestBody PersonEntity personEntity) {
        return personService.save(personEntity);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    public @ResponseBody PersonEntity updatePerson(@RequestBody PersonEntity personEntity) {
        return personService.save(personEntity);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public @ResponseBody PersonEntity getPersonById(@PathVariable Long id) {
        return personService.findOne(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable Long id) {
        personService.delete(id);
    }

}
