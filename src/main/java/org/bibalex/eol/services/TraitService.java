package org.bibalex.eol.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bibalex.eol.collections.Trait;
import org.bibalex.eol.repositories.TraitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class TraitService {

    @Autowired
    private TraitRepository traitRepository;

    public List<Trait> getAllTraits()
    {
        return traitRepository.findAll();
    }

    public Trait createTrait(Trait trait)
    {
        return traitRepository.save(trait);
    }

    public void insertTraits (List<Trait> traits) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        File nodes_file = new File("traits.json");
        FileWriter fileWriter = new FileWriter(nodes_file, true);
        mapper.writeValue(nodes_file, traits);
        // check coming json array if its size + the size of the existing file will exceed the linit (16MB)
        // then mongo import first then write the coming records. otherwise simple write in file.
        ProcessBuilder pb = new ProcessBuilder("/home/ba/eol_repository/nodes.sh", "test", "node", "nodes.json");
        File errorFile = new File("PingErrLog.txt");
        pb.redirectError(errorFile);
        pb.start();
    }

    public List<Trait> getByResourceId(int resourceId) {
        return traitRepository.findByresourceId(resourceId);
    }

}
