package com.essaisprint.firstspring.daos;

import java.util.List;

import com.essaisprint.firstspring.models.Vote;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * VoteDao
 */
public interface VoteDao extends JpaRepository<Vote, Long>{
    Vote findByIdElecteurAndIdElection(long idElecteur, long idElection);
    List<Vote> findByIdCandidatAndIdElection(long idCandidat, long idElection);
    List<Vote> findByIdElection(long idElection);
    
}
