package org.bibalex.eol.controllers;

import org.bibalex.eol.collections.Medium;
import org.bibalex.eol.services.MediumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/media")
public class MediumController {

    @Autowired
    MediumService mediumServ;

    //TODO: Versioning , pagination
    @RequestMapping(value="/getByResource/{resourceId}", method = RequestMethod.GET)
    public List<Medium> getByResourceId(@PathVariable("resourceId")int resourceId)
    {

        return mediumServ.getByResourceId(resourceId);
    }

    @RequestMapping(value="/getByResourceAndPk/{resourceId}/{mediumId}", method = RequestMethod.GET)
    public Medium getByResourceAndPk(@PathVariable("resourceId") int resourceId, @PathVariable("mediumId") String mediumId)
    {
           return mediumServ.getByResourceAndPk(resourceId, mediumId);
    }

    @RequestMapping(value="/insert", method = RequestMethod.POST, consumes = "application/json" )
    public void insertMedia(List<Medium> media)
    {
          //TODO
           mediumServ.insertMedia(media);
    }

    @RequestMapping(value="/count", method = RequestMethod.GET)
    public long countMedia()
    {
       return mediumServ.countMedia();
    }

    //todo: reharvest
    //Updating instances by resource_id and resource_pk, setting a variable set of fields/values


}
