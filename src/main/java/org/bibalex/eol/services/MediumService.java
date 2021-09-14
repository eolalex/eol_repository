package org.bibalex.eol.services;

import org.bibalex.eol.collections.Medium;
import org.bibalex.eol.handler.APIConfiguration;
import org.bibalex.eol.repositories.MediumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediumService {
    @Autowired
    MediumRepository mediumRepo;

    @Autowired
    APIConfiguration apiConfiguration;

    public List<Medium> getByResourceId(int resourceId, int page)
    {
        Pageable paging = createMediaPage(page);
        Page<Medium> mediaPage = mediumRepo.findByresourceId(resourceId, paging);
        return mediaPage.getContent();
    }

    public Medium getByResourceAndPk(int resourceId, String mediumId)
    {
        return mediumRepo.findByResourceIdAndMediumId(resourceId,mediumId);
    }

    public void insertMedia(List<Medium> media)
    {
        mediumRepo.insert(media);
    }

    public long countMedia()
    {
        return mediumRepo.count();
    }

    private Pageable createMediaPage(int page)
    {
        return new PageRequest(page, apiConfiguration.getMediaBatchSize());
    }


}
