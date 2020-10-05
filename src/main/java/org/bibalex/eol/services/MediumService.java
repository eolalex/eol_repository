package org.bibalex.eol.services;

import org.bibalex.eol.collections.Medium;
import org.bibalex.eol.repositories.MediumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediumService {
    @Autowired
    MediumRepository mediumRepo;

    public List<Medium> getByResourceId(int resourceId)
    {
        return mediumRepo.findByresourceId(resourceId);
    }

    public Medium getByResourceAndPk(int resourceId, String mediumId)
    {
        return mediumRepo.findByResourceIdAndMediumId(resourceId,mediumId);
    }

    public void insertMedia(List<Medium> media)
    {

    }

    public long countMedia()
    {
        return mediumRepo.count();
    }



}
