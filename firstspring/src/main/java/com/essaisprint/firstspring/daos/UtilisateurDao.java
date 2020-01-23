package com.essaisprint.firstspring.daos;

import com.essaisprint.firstspring.models.Utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ElecteurDao
 */
@Repository
public interface UtilisateurDao  extends JpaRepository<Utilisateur, Long>{

    Utilisateur findByCinAndPassword(String cin, String password);
    Utilisateur findById(long id);
	//void update(Utilisateur currentUtilisateur);
     
}
