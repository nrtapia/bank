package com.ntapia.bank.controller;

import com.ntapia.bank.common.Util;
import com.ntapia.bank.model.Adviser;
import com.ntapia.bank.service.AdviserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller to expose Adviser REST endpoints
 *
 *  GET     /adviser
 *  GET     /adviser/{id}
 *  POST    /adviser
 *  PUT     /adviser/{id}
 *  DELETE  /adviser/{id}
 */
@RestController
@RequestMapping("/adviser")
public class AdviserController {

    private final AdviserService adviserService;

    @Autowired
    public AdviserController(AdviserService adviserService) {
        this.adviserService = adviserService;
    }

    @GetMapping
    public List<Adviser> get() {
        return adviserService.list();
    }

    @GetMapping(Util.PATH_ID)
    public Adviser get(@PathVariable Long id) {
        return adviserService.get(id);
    }

    @PostMapping
    public Adviser post(@RequestBody Adviser adviser) {
        return adviserService.save(adviser);
    }

    @PutMapping(Util.PATH_ID)
    public Adviser put(@RequestBody Adviser adviser, @PathVariable Long id) {
        return adviserService.update(adviser, id);
    }

    @DeleteMapping(Util.PATH_ID)
    public void delete(@PathVariable Long id) {
        adviserService.delete(id);
    }
}
