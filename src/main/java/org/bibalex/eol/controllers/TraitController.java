package org.bibalex.eol.controllers;

import org.bibalex.eol.collections.Node;
import org.bibalex.eol.collections.Trait;
import org.bibalex.eol.services.NodeService;
import org.bibalex.eol.services.TraitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/traits")
public class TraitController {
    @Autowired
    private TraitService traitService;

    //TODO: get using timestamp
    @RequestMapping(value = "/getAllTraits", method = RequestMethod.GET)
    public List<Trait> getAllTraits() {
        return traitService.getAllTraits();
    }

    @RequestMapping(value = "/createTrait", method = RequestMethod.POST, consumes = "application/json")
    public Trait createTrait(@RequestBody Trait trait) {
        return traitService.createTrait(trait);
    }

    @RequestMapping(value= "/insertTrait", method = RequestMethod.POST, consumes = "application/json")
    public void insertTraits (@RequestBody List<Trait> traits) throws IOException {
        //TODO: security issues (authentication)
        traitService.insertTraits(traits);
    }

    @RequestMapping(value="/getByResource/{resourceId}", method = RequestMethod.GET)
    public List<Trait> getByResourceId(@PathVariable("resourceId") int resourceId) {
        return traitService.getByResourceId(resourceId);
    }

    //TODO: reharvest
}
