package org.bibalex.eol.repositories;

import org.bibalex.eol.collections.Medium;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface MediumRepository extends MongoRepository <Medium, UUID> {

      List<Medium> findByresourceId(int resourceId);
      Medium findByResourceIdAndMediumId(int resourceId, String mediumId);

}
