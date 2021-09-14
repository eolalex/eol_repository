package org.bibalex.eol.repositories;

import org.bibalex.eol.collections.Medium;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface MediumRepository extends MongoRepository <Medium, UUID> {

      Page<Medium> findByresourceId(int resourceId, Pageable pageable);
      Medium findByResourceIdAndMediumId(int resourceId, String mediumId);

}
