package org.bibalex.eol.services;

import org.bibalex.eol.collections.Node;
import org.bibalex.eol.handler.APIConfiguration;
import org.bibalex.eol.repositories.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ResourceService {
    @Autowired
    private NodeRepository nodeRepo;

    @Autowired
    APIConfiguration apiConfiguration;

    public Page<Node> getByResourceId(int resourceId, int page)
    {
        Pageable paging = createNodesPage(page);
        Page<Node> nodesPage = nodeRepo.findByresourceId(resourceId, paging);
        return nodesPage;
    }

    private Pageable createNodesPage(int page)
    {
        return new PageRequest(page, apiConfiguration.getNodesBatchSize());
    }
}
