package org.bibalex.eol.controllers;

import org.bibalex.eol.collections.Node;
import org.bibalex.eol.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/resources")
public class ResourceController {

    @Autowired
    private ResourceService resourceServ;

    @RequestMapping(value="/{resourceId}/nodes", method = RequestMethod.GET)
    public ResponseEntity getByResourceId(@PathVariable("resourceId") int resourceId, @RequestParam(defaultValue = "0") int page)
    {
        Page<Node> nodesPage = resourceServ.getByResourceId(resourceId, page);
        List<Node> nodes = nodesPage.getContent();
        Map<String, Object> response = new HashMap<>();
        response.put("nodes", nodes);
        response.put("currentPage", nodesPage.getNumber());
        response.put("totalItems", nodesPage.getTotalElements());
        response.put("totalPages", nodesPage.getTotalPages());
        return ResponseEntity.ok(response);

    }
}
