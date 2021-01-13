package org.bibalex.eol.repositories;

import org.bibalex.eol.collections.Node;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
public interface NodeRepository extends MongoRepository<Node, String> {

    Page<Node> findByresourceId(int resourceId, Pageable pageable);
    Node findByResourceIdAndNodeId(int resourceId, String nodeId);
    Long countByAcceptedNameUsageId(String acceptedNameUsageId);
    String countVernaculars();

    @Query("{'modifiedAt': {$gte: ?0, $lte:?1 }}")
    List<Node> findByModifiedAtBetween(Instant from, Instant to);
}
