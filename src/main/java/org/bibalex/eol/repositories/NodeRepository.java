package org.bibalex.eol.repositories;

import org.bibalex.eol.collections.Node;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.time.Instant;
import java.util.List;

public interface NodeRepository extends MongoRepository<Node, String> , NodeRepositoryCustom{

    List<Node> findByresourceId(int resourceId);
    Node findByResourceIdAndNodeId(int resourceId, String nodeId);
    Long countByAcceptedNameUsageId(String acceptedNameUsageId);

    @Query(value = "{'modifiedAt' : {$gte : ?0, $lt: ?1 }}")
    List<Node> findByModifiedAtBetween(Instant from, Instant to);





}
