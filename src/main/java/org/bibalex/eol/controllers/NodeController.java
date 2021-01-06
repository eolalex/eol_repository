package org.bibalex.eol.controllers;


import org.bibalex.eol.collections.Node;
import org.bibalex.eol.services.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.time.Instant;
import java.util.List;
import java.util.ArrayList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by maha.mostafa on 11/12/19.
 */
@RestController
@RequestMapping("/nodes")
public class NodeController {
    @Autowired
    private NodeService nodeServ;
    @Value("${size}")
    private int size;

    @RequestMapping(value = "/getAllNodes", method = RequestMethod.GET)
    public List<Node> getAllNodes() {
        return nodeServ.getAllNodes();
    }

    @RequestMapping(value="/getByTimestamps", method = RequestMethod.POST)
    public List<Node> getByTimestamps(@RequestParam ("from") String from , @RequestParam ("to") String to)
    {
        return nodeServ.getByTimestamps(Instant.parse(from),Instant.parse(to));
    }

    /**
     * Gets the nodes that are mdified between the input date range.
     * @param from UTC date parameter represents the start of the required period
     * @param to UTC date parameter represents the end of the required period
     * @param page the number of the required page
     * @return a map includes the resulted nodes and information about the total result
     */
    @RequestMapping(value="/getNodesByDatetime", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> getNodesByDatetime(@RequestParam ("from") String from, @RequestParam ("to") String to, @RequestParam ("page") String page)
    {
        // TODO validaton of input UTC date
        List<Node> nodes = new ArrayList<Node>();
        Pageable paging = new PageRequest(Integer.parseInt(page),size);
        try {
            Page<Node> nodesPage;
            nodesPage = nodeServ.getNodesByDatetime(Instant.parse(from), Instant.parse(to), paging);
            nodes = nodesPage.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("nodes", nodes);
            response.put("currentPage", nodesPage.getNumber());
            response.put("totalItems", nodesPage.getTotalElements());
            response.put("totalPages", nodesPage.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/createNode", method = RequestMethod.POST, consumes = "application/json")
    public boolean createNode(@RequestBody Node node)
    {
        return nodeServ.createNode(node)== null;
    }

    @RequestMapping(value= "/insert", method = RequestMethod.POST, consumes = "application/json")
    public void insertNodes (@RequestBody List<Node> nodes) throws IOException
    {
        //TODO: security issues (authentication)
        nodeServ.insertNodes(nodes);

    }

    @RequestMapping(value="/getByResource/{resourceId}", method = RequestMethod.GET)
    public List<Node> getByResourceId(@PathVariable("resourceId") int resourceId)
    {
        return nodeServ.getByResourceId(resourceId);

    }

    @RequestMapping(value="/countScientific", method = RequestMethod.GET)
    public long countScientificNames()
    {
        return nodeServ.countScientificNames();

    }
//
    @RequestMapping(value="/getByResourceAndPk/{resourceId}/{nodeId}", method = RequestMethod.GET)
    public Node findByResourceAndNode(@PathVariable("resourceId") int resourceId, @PathVariable("nodeId") String nodeId)
    {
        return nodeServ.getByResourceAndPk(resourceId, nodeId);
    }

    // Nodes are taxa which are not synonms
    @RequestMapping(value="/countNodes", method = RequestMethod.GET)
    public long countNodes()
    {
        return nodeServ.countNodes();
    }

    @RequestMapping(value="/countVernaculars", method = RequestMethod.GET )
    public String countVernaculars()
    {
        return nodeServ.countVernaculars();
    }


    //TODO: reharvest






}