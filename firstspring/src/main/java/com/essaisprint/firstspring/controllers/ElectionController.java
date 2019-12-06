package com.essaisprint.firstspring.controllers;

import java.net.URI;

import com.essaisprint.firstspring.daos.ElectionDao;
import com.essaisprint.firstspring.models.Election;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * ElectionController
 */

@RestController
public class ElectionController {

    @Autowired
    private ElectionDao electionDao;
    //@CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/elections")
    public ResponseEntity<Election> ajouterElection(@RequestBody Election Election) {
        Election electionAdded = electionDao.save(Election);
      
        
        if (electionAdded == null)
             return ResponseEntity.noContent().build();
             
        //  URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        //          .buildAndExpand(electionAdded.getId()).toUri();
          return new ResponseEntity<Election>(electionAdded, HttpStatus.CREATED);
         
    }
    @GetMapping(value="/elections")
    public ResponseEntity< Iterable<Election>> getElections() {
        Iterable<Election> elections = electionDao.findAll();
    
        return new ResponseEntity< Iterable<Election>>(elections, HttpStatus.OK);
    }
    

}
