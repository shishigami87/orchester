package eu.shishigami.orchester.web.controller;

import eu.shishigami.orchester.domain.entity.InstrumentEntity;
import eu.shishigami.orchester.domain.service.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Marcel Herd on 11.03.14.
 */
@Controller
@RequestMapping("/person/{personId}/instrument")
public class InstrumentController {

    @Autowired
    private InstrumentService instrumentService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<InstrumentEntity> getAllInstrumente() {
        return instrumentService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody InstrumentEntity saveInstrument(@RequestBody InstrumentEntity instrumentEntity) {
        return instrumentService.save(instrumentEntity);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    public @ResponseBody InstrumentEntity updateInstrument(@RequestBody InstrumentEntity instrumentEntity) {
        return instrumentService.save(instrumentEntity);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public @ResponseBody InstrumentEntity getInstrumentById(@PathVariable Long id) {
        return instrumentService.findOne(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteInstrument(@PathVariable Long id) {
        instrumentService.delete(id);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleBadRequest(HttpMessageNotReadableException e) {
        e.printStackTrace();
    }

}
