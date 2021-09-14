package org.bibalex.eol.repositories;

import org.bibalex.eol.collections.Node;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.Instant;
import java.util.List;
public interface NodeRepository extends MongoRepository<Node, String>,NodeRepositoryCustom {

    Page<Node> findByresourceId(int resourceId, Pageable pageable);
    Node findByResourceIdAndNodeId(int resourceId, String nodeId);
    Node findBy_id(String generatedNodeId);
    Long countByAcceptedNameUsageId(String acceptedNameUsageId);
    String countVernaculars();

    @Query("{'modifiedAt': {$gte: ?0, $lte:?1 }}")
    Page<Node> findByModifiedAtBetween(Instant from, Instant to, Pageable pageable);
}
