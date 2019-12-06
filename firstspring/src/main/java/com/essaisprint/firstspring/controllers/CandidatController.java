package com.essaisprint.firstspring.controllers;


import com.essaisprint.firstspring.daos.UtilisateurDao;
import com.essaisprint.firstspring.models.Utilisateur;

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
    private UtilisateurDao utilisateurDao;
    
    @PostMapping(value="/add_new_user")
    public ResponseEntity<Utilisateur> ajouter(@RequestBody Utilisateur utilisateur) {
        
        Utilisateur utilisateurAdded = utilisateurDao.save(utilisateur);      
        
        if (utilisateurAdded == null)
             return ResponseEntity.noContent().build();
             
          return new ResponseEntity<Utilisateur>(utilisateurAdded, HttpStatus.CREATED);
         
    }
    @GetMapping(value="/utilisateurs")
    public ResponseEntity< Iterable<Utilisateur>> getUtilisateurs() {
        Iterable<Utilisateur> utilisateurs = utilisateurDao.findAll();
    
        return new ResponseEntity< Iterable<Utilisateur>>(utilisateurs, HttpStatus.OK);
    }
}
