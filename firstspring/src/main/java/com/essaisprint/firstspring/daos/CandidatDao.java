package com.essaisprint.firstspring.daos;

import com.essaisprint.firstspring.models.Candidat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CandidatDao
 */
@Repository
public interface CandidatDao extends JpaRepository<Candidat, Long> {

    
}
