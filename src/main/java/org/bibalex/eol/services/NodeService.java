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

    public void insertNodes (List<Node> nodes) throws IOException
    {
        //addModifiedAt(nodes);
        addModifiedAt(nodes);
        nodeRepo.insert(nodes);
//        ObjectMapper mapper = new ObjectMapper();
//        File nodes_file = new File("nodes.json");
//        FileWriter fileWriter = new FileWriter(nodes_file, true);
//       // mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        mapper.writeValue(nodes_file, nodes);
//        // default attributes like modified_at have to be assigned.
//        // check coming json array if its size + the size of the existing file will exceed the linit (16MB)
//        // then mongo import first then write the coming records. otherwise simple write in file.
//        ProcessBuilder pb = new ProcessBuilder("/home/ba/eol_repository/nodesInsertion.sh", "test", "node", "nodes.json");
//        File errorFile = new File("PingErrLog.txt");
//        pb.redirectError(errorFile);
//        pb.start();
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

    public  List<Node> getByTimestamps(Instant from, Instant to)
    {
        return nodeRepo.findByModifiedAtBetween(from,to);
    }

}
