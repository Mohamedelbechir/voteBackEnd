package com.essaisprint.firstspring.controllers;

import java.net.URI;

import com.essaisprint.firstspring.daos.ElectionDao;
import com.essaisprint.firstspring.models.Election;
import com.essaisprint.firstspring.models.Utilisateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


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

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(value = "elections/{id}")
    public ResponseEntity<Election> update(@PathVariable String id,@RequestBody Election election){
      
        HttpHeaders headers = new HttpHeaders();
		if(election == null){ 
			return new ResponseEntity<Election>(headers, HttpStatus.BAD_REQUEST);
		}
		Election currentElection = this.electionDao.findById(Long.parseLong(id));
		if(currentElection == null){ 
			return new ResponseEntity<Election>(HttpStatus.NOT_FOUND);
        }

        currentElection.setDateDebut(election.getDateDebut());
        currentElection.setDateFin(election.getDateFin());
        currentElection.setEtat(election.getEtat());
        currentElection.setLibele(election.getLibele());
        currentElection.setType(election.getType());    

       currentElection.clearElections();     

        for(Utilisateur candidat : election.getCandidats()) { 
			currentElection.addCandidat(candidat);
		}
        this.electionDao.save(currentElection);
         
		return new ResponseEntity<Election>(currentElection, HttpStatus.OK);
    }

   

    @GetMapping(value="/elections")
    public ResponseEntity< Iterable<Election>> getElections() {
        Iterable<Election> elections = electionDao.findAll();
    
        return new ResponseEntity< Iterable<Election>>(elections, HttpStatus.OK);
    }   


}
