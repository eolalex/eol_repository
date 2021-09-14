package org.bibalex.eol.controllers;


import org.bibalex.eol.collections.Node;
import org.bibalex.eol.services.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
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

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity getAllNodes(@RequestParam (defaultValue = "0") int page) {
        Page<Node> nodesPage = nodeServ.getAllNodes(page);
        List<Node> nodes = nodesPage.getContent();
        Map<String, Object> response = new HashMap<>();
        response.put("nodes", nodes);
        response.put("currentPage", nodesPage.getNumber());
        response.put("totalItems", nodesPage.getTotalElements());
        response.put("totalPages", nodesPage.getTotalPages());
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value="/getByModifiedAt", method = RequestMethod.GET)
    public ResponseEntity getByModifiedAt(@RequestParam ("from") String from , @RequestParam ("to") String to, @RequestParam (defaultValue = "0") int page)
    {
        Page<Node> nodesPage = nodeServ.getByModifiedAt(Instant.parse(from), Instant.parse(to),page);
        List<Node> nodes = nodesPage.getContent();
        Map<String, Object> response = new HashMap<>();
        response.put("nodes", nodes);
        response.put("currentPage", nodesPage.getNumber());
        response.put("totalItems", nodesPage.getTotalElements());
        response.put("totalPages", nodesPage.getTotalPages());
        return ResponseEntity.ok(response);
    }


// TODO update all responses to return more details like this response
//    /**
//     * Gets the nodes that are mdified between the input date range.
//     * @param from UTC date parameter represents the start of the required period
//     * @param to UTC date parameter represents the end of the required period
//     * @param page the number of the required page
//     * @return a map includes the resulted nodes and information about the total result
//     */
//    @RequestMapping(value="/getNodesByDatetime", method = RequestMethod.POST)
//    public ResponseEntity<Map<String, Object>> getNodesByDatetime(@RequestParam ("from") String from, @RequestParam ("to") String to, @RequestParam ("page") String page)
//    {
//        // TODO validaton of input UTC date
//        List<Node> nodes = new ArrayList<Node>();
//        Pageable paging = new PageRequest(Integer.parseInt(page),size);
//        try {
//            Page<Node> nodesPage;
//            nodesPage = nodeServ.getNodesByDatetime(Instant.parse(from), Instant.parse(to), paging);
//            nodes = nodesPage.getContent();
//
//            Map<String, Object> response = new HashMap<>();
//            response.put("nodes", nodes);
//            response.put("currentPage", nodesPage.getNumber());
//            response.put("totalItems", nodesPage.getTotalElements());
//            response.put("totalPages", nodesPage.getTotalPages());
//
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @RequestMapping(value = "/createNode", method = RequestMethod.POST, consumes = "application/json")
    public boolean createNode(@RequestBody Node node)
    {
        return nodeServ.createNode(node)== null;
    }

    @RequestMapping(value= "", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity insertNodes (@RequestBody List<Node> nodes) throws IOException
    {
        //TODO: security issues (authentication)
        return ResponseEntity.status(HttpStatus.CREATED).body(nodeServ.insertNodes(nodes));
    }



    @RequestMapping(value="/scientificNamesCount", method = RequestMethod.GET)
    public ResponseEntity countScientificNames()
    {
        long scientificNamesCount = nodeServ.countScientificNames();
        HashMap<String,Long> result= new HashMap<String,Long>();
        result.put("scientificNamesCount",scientificNamesCount);
        return ResponseEntity.ok(result);
    }
//
    @RequestMapping(value="/getByResourceAndPk/{resourceId}/{nodeId}", method = RequestMethod.GET)
    public ResponseEntity findByResourceAndNode(@PathVariable("resourceId") int resourceId, @PathVariable("nodeId") String nodeId)
    {
        Node requestedNode = nodeServ.getByResourceAndPk(resourceId, nodeId);
        if(requestedNode == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(requestedNode);
    }

    @RequestMapping(value="/{generatedNodeId}", method = RequestMethod.GET)
    public ResponseEntity findByGeneratedNodeId(@PathVariable("generatedNodeId") int generatedNodeId)
    {
        Node requestedNode = nodeServ.getByGeneratedNodeId(generatedNodeId);
        if(requestedNode == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(requestedNode);
    }

    // Nodes are taxa which are not synonms
    @RequestMapping(value="/nodesCount", method = RequestMethod.GET)
    public ResponseEntity countNodes()
    {
        long nodesCount = nodeServ.countNodes();
        HashMap<String,Long> result= new HashMap<String,Long>();
        result.put("nodesCount",nodesCount);
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value="/vernacularsCount", method = RequestMethod.GET )
    public ResponseEntity countVernaculars()
    {
        String vernacularsCount = nodeServ.countVernaculars();
        HashMap<String,String> result= new HashMap<String,String>();
        result.put("vernacularsCount",vernacularsCount);
        return ResponseEntity.ok(result);
    }


    //TODO: reharvest






}