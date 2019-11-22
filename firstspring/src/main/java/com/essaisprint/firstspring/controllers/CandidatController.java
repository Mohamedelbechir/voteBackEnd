package com.essaisprint.firstspring.controllers;

import com.essaisprint.firstspring.daos.CandidatDao;
import com.essaisprint.firstspring.models.Candidat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * CandidatController
 */
@RestController
public class CandidatController {

    @Autowired
    private CandidatDao candidatDao;
    
    @PostMapping(value="/candidats")
    public ResponseEntity<Candidat> ajouterCandidat(@RequestBody Candidat Candidat) {

        Candidat candidatAdded = candidatDao.save(Candidat);
      
        
        if (candidatAdded == null)
             return ResponseEntity.noContent().build();
             
          return new ResponseEntity<Candidat>(candidatAdded, HttpStatus.CREATED);
         
    }
    @GetMapping(value="/candidats")
    public ResponseEntity< Iterable<Candidat>> getCandidats() {
        Iterable<Candidat> candidats = candidatDao.findAll();
    
        return new ResponseEntity< Iterable<Candidat>>(candidats, HttpStatus.OK);
    }
}
