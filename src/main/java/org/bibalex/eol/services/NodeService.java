package org.bibalex.eol.services;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.jni.Time;
import org.bibalex.eol.collections.Node;
import org.bibalex.eol.handler.APIConfiguration;
import org.bibalex.eol.repositories.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import java.util.ArrayList;



@Service
public class NodeService {

    @Autowired
    private NodeRepository nodeRepo;

    @Autowired
    APIConfiguration apiConfiguration;

    public List<Node> getAllNodes(int page)
    {
        Pageable paging = createNodesPage(page);
        Page<Node> nodesPage = nodeRepo.findAll(paging);
        return nodesPage.getContent();
    }

    public List<Node> getByResourceId( int resourceId, int page)
    {
        Pageable paging = createNodesPage(page);
        Page<Node> nodesPage = nodeRepo.findByresourceId(resourceId, paging);
        return nodesPage.getContent();
    }

    private Pageable createNodesPage(int page)
    {
        return new PageRequest(page, apiConfiguration.getNodesBatchSize());
    }

    public Node createNode(Node node)
    {
        return nodeRepo.save(node);
    }

    public void insertNodes (List<Node> nodes) throws IOException {
        nodeRepo.insert(nodes);
    }

    private void addModifiedAt(List<Node> nodes)
    {
        for(Node node : nodes)
            node.setModifiedAt(Instant.now());
    }

     public long countScientificNames()
    {
        return nodeRepo.count();

    }

    public Node getByResourceAndPk( int resourceId, String nodeId)
    {
        return nodeRepo.findByResourceIdAndNodeId(resourceId, nodeId);
    }

    public long countNodes()
    {
        return nodeRepo.countByAcceptedNameUsageId(null);
    }

    public String countVernaculars()
    {
        return nodeRepo.countVernaculars();
    }

    /**
     * Gets the nodes that are mdified between the input date range.
     * @param from UTC date parameter represents the start of the required period
     * @param to UTC date parameter represents the end of the required period
     * @param page number of the request
     * @return a list of the resulted nodes.
     */
    public  List<Node> getByModifiedAt(Instant from, Instant to, int page)
    {
        Pageable paging = createNodesPage(page);
        Page<Node> nodesPage = nodeRepo.findByModifiedAtBetween(from,to,paging);
        return nodesPage.getContent();
    }



}
